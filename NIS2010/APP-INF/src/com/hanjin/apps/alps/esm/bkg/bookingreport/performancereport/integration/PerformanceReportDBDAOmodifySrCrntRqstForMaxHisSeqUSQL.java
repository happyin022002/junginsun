/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOmodifySrCrntRqstForMaxHisSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.11 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOmodifySrCrntRqstForMaxHisSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DPCS에서 신규 생성한 SR HISTORY SEQ를 UPDATE
	  * </pre>
	  */
	public PerformanceReportDBDAOmodifySrCrntRqstForMaxHisSeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOmodifySrCrntRqstForMaxHisSeqUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_SR_CRNT_RQST RQ" ).append("\n"); 
		query.append("SET     RQ.MAX_HIS_SEQ      = @[sr_his_seq]" ).append("\n"); 
		query.append("#if (${sr_sts_cd} == 'XX')" ).append("\n"); 
		query.append(",       RQ.SR_CRNT_STS_CD   = 'XX'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE  RQ.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${sr_sts_cd} == 'XX')" ).append("\n"); 
		query.append("AND    RQ.SR_NO     != @[sr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    RQ.SR_NO   	= @[sr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}