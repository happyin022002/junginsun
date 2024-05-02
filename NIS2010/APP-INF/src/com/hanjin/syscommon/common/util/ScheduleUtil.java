/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : ScheduleUtil.java
 *@FileTitle : ScheduleUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 김경범
 *@LastVersion : 1.0
 * 2009.06.30 김경범
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.management.alps.schedule.integration.ScheduleDBDAO;

/**
 * ScheduleUtil AutoSys 연동 
 * 
 * @author desis
 * @see ScheduleDAO
 * @since J2EE 1.4
 */
public class ScheduleUtil {

	Logger log = Logger.getLogger(this.getClass());
	String prefix = "T_"; 

	/**
	 * 생성자
	 */
	public ScheduleUtil() {
		String ssoTargetUrl = SiteConfigFactory.get("COM.HANJIN.SSO.TARGET");
		if ( ssoTargetUrl.indexOf("alps.smlines.com") > 0 ) prefix = "L_";
		else if ( ssoTargetUrl.indexOf("alpsedu.hanjin.com") > 0 ) prefix = "L_";
		else if ( ssoTargetUrl.indexOf("scalps.hanjin.com") > 0 ) prefix = "L_";
		else if ( ssoTargetUrl.indexOf("gem.hanjin.com") > 0 ) prefix = "G_";
	}	
	
	/**
	 * 시스템 커맨드 실행
	 * 
	 * @param cmd 실행 커맨드
	 * @return String
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	private String executeShellCommand(String cmd) throws IOException, InterruptedException {
		log.error("Command Entered: " + cmd);
		Runtime run = Runtime.getRuntime();
		Process pr;
		pr = run.exec(cmd);
		pr.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		StringBuffer msgBuf = new StringBuffer();
		String line = "";
		while ((line=buf.readLine())!=null) {
			msgBuf.append(line);
		}
		buf.close();
		log.error("Execution Message Result: " + msgBuf.toString());
		return msgBuf.toString();
	}

	/**
	 * 업무시스템에서 직접 작업을 실행하기 위한 메소드
	 * 
	 * @param pgmNo 프로그램 번호
	 * @return String Autosys Run Number
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws DAOException 
	 */
	public String directExecuteJob(String pgmNo) throws IOException, InterruptedException, DAOException {
		executeShellCommand("/batctx/event/startjob.sh "+prefix+pgmNo);
		
		String jobId = "";
		int searchCount = 0; //30초
		
		if(prefix.equals("T_")) return prefix+pgmNo;
		while(true) {
			jobId = (new ScheduleDBDAO()).getDirectExecuteJobID(prefix+pgmNo);
			
			if(jobId != null && !jobId.equals("")) {
				break;
			}
			if(searchCount > 30) {
				break;
			}
			searchCount++;
			
			Thread.sleep(1000);
		}
		
		return jobId;
	}
	
	/**
	 * 업무시스템에서 직접 작업을 파라미터와 함께 실행하기 위한 메소드
	 * @param pgmNo
	 * @param parameter
	 * @param multi
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws DAOException
	 */
	public String directExecuteJob(String pgmNo, String parameter, boolean multi) throws IOException, InterruptedException, DAOException {
		return directExecute(pgmNo, parameter, multi);
	}
	
	/**
	 * 업무시스템에서 직접 작업을 파라미터와 함께 실행하기 위한 메소드
	 * @param pgmNo
	 * @param parameter
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws DAOException
	 */
	public String directExecuteJob(String pgmNo, String parameter) throws IOException, InterruptedException, DAOException {
		return directExecute(pgmNo, parameter, false);
	}
	
	/**
	 * 업무시스템에서 직접 작업을 파라미터와 함께 실행하기 위한 메소드
	 * @param pgmNo
	 * @param parameter
	 * @param multi
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws DAOException
	 */
	private String directExecute(String pgmNo, String parameter, boolean multi) throws IOException, InterruptedException, DAOException {
		if(multi){
			executeShellCommand("/batctx/multi_execute.sh " + pgmNo + " " + parameter);
		}else{
			executeShellCommand("/batctx/event/setparam.sh "+prefix+pgmNo+" "+parameter);
			executeShellCommand("/batctx/event/startjob.sh "+prefix+pgmNo);
		}
		String jobId = "";
		int searchCount = 0; //30초
		
		if(prefix.equals("T_")) return prefix+pgmNo;
		while(true) {
			jobId = (new ScheduleDBDAO()).getDirectExecuteJobID(prefix+pgmNo);
			
			if(jobId != null && !jobId.equals("")) {
				break;
			}
			if(searchCount > 30) {
				break;
			}
			searchCount++;
			
			Thread.sleep(1000);
		}
		
		return jobId;
	}

	/**
	 * 업무시스템에서 직접 작업을 스케쥴러에 예약하기 위한 메소드
	 * 
	 * @param pgmNo 프로그램 번호
	 * @param reserveTime 작업 예약 시간 yyyymmddhh24mi
	 * @return String Autosys Event ID
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws DAOException 
	 */
	public String reserveExecuteJob(String pgmNo, String reserveTime) throws ParseException, IOException, InterruptedException, DAOException {
		java.text.SimpleDateFormat format_api = new java.text.SimpleDateFormat("yyyyMMddHHmm");
		java.util.Date date = format_api.parse(reserveTime);
		java.text.SimpleDateFormat format_autosys = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm");
		executeShellCommand("/batctx/event/reservejob.sh "+prefix+pgmNo+" "+format_autosys.format(date));
		if(prefix.equals("T_")) return prefix+pgmNo;
		return (new ScheduleDBDAO()).getReserveExecuteJobID(prefix+pgmNo);
	}

	/**
	 * 업무시스템에서 직접 작업을 스케쥴러에 예약하기 위한 메소드
	 * 
	 * @param pgmNo 프로그램 번호
	 * @param reserveTime 작업 예약 시간 yyyymmddhh24mi
	 * @param parameter 작업에 전달될 값
	 * @return String Autosys Event ID
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws DAOException 
	 */
	public String reserveExecuteJob(String pgmNo, String reserveTime, String parameter) throws ParseException, IOException, InterruptedException, DAOException {
		java.text.SimpleDateFormat format_api = new java.text.SimpleDateFormat("yyyyMMddHHmm");
		java.util.Date date = format_api.parse(reserveTime);
		java.text.SimpleDateFormat format_autosys = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm");
		executeShellCommand("/batctx/event/setparam.sh "+prefix+pgmNo+" "+parameter);
		executeShellCommand("/batctx/event/reservejob.sh "+prefix+pgmNo+" "+format_autosys.format(date));
		if(prefix.equals("T_")) return prefix+pgmNo;
		return (new ScheduleDBDAO()).getReserveExecuteJobID(prefix+pgmNo);
	}

	/**
	 * 업무시스템에서 등록한 작업을 스케쥴링 상태를 조회하기 위한 메소드
	 * status 0 <NULL> 알수없음 
	 * status 1 RUNNING 수행중 
	 * status 3 STARTING 시작(시스템) 
	 * status 4 SUCCESS 성공 
	 * status 5 FAILURE 실패 
	 * status 6 TERMINATED 강제종료 
	 * status 7 ON_ICE 논리삭제 
	 * status 8 INACTIVE 실행대기
	 * status 9 ACTIVATED 활성화(시스템) 
	 * status 10 RESTART 시작시에러 
	 * status 11 ON_HOLD 일시정지 
	 * status 12 QUE_WAIT 로드밸런싱 대기
	 * 
	 * @param id
	 * @param pgmNo
	 * @return status
	 * @throws NumberFormatException 
	 * @throws DAOException 
	 */
	public int getJobStatus(String id, String pgmNo) throws NumberFormatException, DAOException {
		if(prefix.equals("T_")) return 0;
		return Integer.parseInt((new ScheduleDBDAO()).getJobRunsInfo(id, prefix+pgmNo).get("status"));
	}

	/**
	 * 작업의 시작 시간을 확인하는 함수
	 * 
	 * @param id
	 * @param pgmNo
	 * @return String yyyy-mm-dd hh24:mi:ss 포맷의 문자열
	 * @throws DAOException 
	 */
	public String getJobStartTime(String id, String pgmNo) throws DAOException {
		if(prefix.equals("T_")) return "";
		return (new ScheduleDBDAO()).getJobRunsInfo(id, prefix+pgmNo).get("startime");
	}

	/**
	 * 작업의 종료 시간을 확인하는 함수
	 * 
	 * @param id
	 * @param pgmNo
	 * @return String yyyy-mm-dd hh24:mi:ss 포맷의 문자열
	 * @throws DAOException 
	 */
	public String getJobEndTime(String id, String pgmNo) throws DAOException {
		if(prefix.equals("T_")) return "";
		return (new ScheduleDBDAO()).getJobRunsInfo(id, prefix+pgmNo).get("endtime");
	}

	/**
	 * 작업을 취소하는 함수
	 * 
	 * @param pgmNo 프로그램 번호
	 * @return boolean true:성공 false:실패
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public boolean cancelJob(String pgmNo) throws IOException, InterruptedException {
		String msg = executeShellCommand("/batctx/event/canceljob.sh "+prefix+pgmNo);
		log.debug(msg);
		return (msg.indexOf("eoid:")>0) ? true : false;
	}

	/**
	 * 특정 모듈에서 프로그램 번호로 현재 스케쥴러에서 구동되고 있는지 확인하는 함수
	 * 
	 * @param pgmNo 프로그램 번호
	 * @return boolean true:동작중 false:없음
	 * @throws DAOException 
	 */
	public boolean isRunning(String pgmNo) throws DAOException {
		if(prefix.equals("T_")) return false;
		
		int status = (new ScheduleDBDAO()).getJobStatus(prefix+pgmNo);
		log.error("\nisRunning = " + prefix+pgmNo + " : " + status);
		return (status == 1 || status == 3) ? true : false;
	}


}
