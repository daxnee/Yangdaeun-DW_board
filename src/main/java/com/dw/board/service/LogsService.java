package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.LogsMapper;
import com.dw.board.vo.LogVO;
import com.github.pagehelper.PageHelper;

@Service
public class LogsService {
	
	@Autowired 
	private LogsMapper logsMapper;
	
	// 데이터 기록을 쌓는게 중요하기 때문에 @트랜잭션 할 필요 없다 
	public int setLogs(LogVO vo) {
		return logsMapper.insertLogs(vo);
	}
	
	public List<Map<String, Object>> getLogsList(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return logsMapper.selectBoardLogs(0); // 0 넣으면 xml if문 실행 안됨
	}
	
	public Map<String, Object> getLogs(int logId){
		List<Map<String, Object>> list = logsMapper.selectBoardLogs(logId);
		return list.get(0); // 
	}

}
