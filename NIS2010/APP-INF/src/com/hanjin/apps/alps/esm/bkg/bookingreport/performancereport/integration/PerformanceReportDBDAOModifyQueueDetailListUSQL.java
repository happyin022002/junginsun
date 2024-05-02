/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueDetailListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.12.18 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyQueueDetailListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOModifyQueueDetailListUSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueDetailListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueDetailListUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("UPDATE BKG_SR_CRNT_RQST X" ).append("\n"); 
		query.append("SET (SR_CRNT_STS_CD, SR_CRNT_INFO_CD,    RTN_FM_STS_CD,     RTN_FM_USR_ID, SR_RTN_TO_STS_CD," ).append("\n"); 
		query.append("RTN_TO_USR_ID,  RTN_TO_RTN_STS_CD, RTN_TO_RTN_USR_ID, RTN_TO_RTN_DT, RTN_DT," ).append("\n"); 
		query.append("CRNT_DT,        CRNT_USR_ID,       UPD_DT,            PND_FLG)" ).append("\n"); 
		query.append("=" ).append("\n"); 
		query.append("( SELECT  DECODE(@[wrk_grp_cd], 'I', 'ID', 'R', 'RD', 'A', 'AD', '  ')," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.SR_CRNT_INFO_CD,'N')," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_FM_STS_CD,NULL)," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_FM_USR_ID,NULL)," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.SR_RTN_TO_STS_CD,NULL)," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_TO_USR_ID,NULL)," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_TO_RTN_STS_CD,NULL)," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_TO_RTN_USR_ID,NULL)," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_TO_RTN_DT,NULL)," ).append("\n"); 
		query.append("DECODE(A.SR_CRNT_INFO_CD,'N',X.RTN_DT,NULL)," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[pnd_flg]," ).append("\n"); 
		query.append("FROM ( SELECT *" ).append("\n"); 
		query.append("FROM ( SELECT SR_CRNT_INFO_CD" ).append("\n"); 
		query.append("FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("WHERE SR_KND_CD =@[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("AND BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND SR_NO =@[sr_no]" ).append("\n"); 
		query.append("AND SR_AMD_TP_CD = @[sr_kind]/* 0421의 SR_KND_CD*/" ).append("\n"); 
		query.append("ORDER BY SR_AMD_SEQ DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE SR_KND_CD =@[src_cd] /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("AND BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND SR_NO =@[sr_no]" ).append("\n"); 
		query.append("AND SR_AMD_TP_CD = @[sr_kind]/* 0421의 SR_KND_CD*/" ).append("\n"); 
		query.append("AND SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ)" ).append("\n"); 
		query.append("FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("WHERE SR_KND_CD = X.SR_KND_CD" ).append("\n"); 
		query.append("AND SR_NO = X.SR_NO" ).append("\n"); 
		query.append("AND BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("AND SR_AMD_TP_CD = X.SR_AMD_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}