/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOModifySrTransferCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.22 김기종
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

public class PerformanceReportDBDAOModifySrTransferCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DPCS Transfer
	  * </pre>
	  */
	public PerformanceReportDBDAOModifySrTransferCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifySrTransferCSQL").append("\n"); 
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
		query.append("INSERT INTO  BKG_SR_HIS SH " ).append("\n"); 
		query.append("(		SH.SR_KND_CD     " ).append("\n"); 
		query.append(",       SH.SR_NO" ).append("\n"); 
		query.append(",       SH.BKG_NO" ).append("\n"); 
		query.append(",       SH.SR_HIS_SEQ" ).append("\n"); 
		query.append(",       SH.SR_STS_CD" ).append("\n"); 
		query.append(",       SH.SR_PROC_STS_CD" ).append("\n"); 
		query.append(",       SH.ATND_USR_ID" ).append("\n"); 
		query.append(",       SH.SR_PROC_UPD_DT" ).append("\n"); 
		query.append(",       SH.ST_DT" ).append("\n"); 
		query.append(",       SH.DIFF_RMK" ).append("\n"); 
		query.append(",       SH.CRE_DT" ).append("\n"); 
		query.append(",       SH.CRE_USR_ID" ).append("\n"); 
		query.append(",       SH.UPD_DT    " ).append("\n"); 
		query.append(",       SH.UPD_USR_ID  )" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("SELECT DISTINCT RQ.SR_KND_CD" ).append("\n"); 
		query.append(",      RQ.SR_NO" ).append("\n"); 
		query.append(",      RQ.BKG_NO" ).append("\n"); 
		query.append(",      @[sr_his_seq]" ).append("\n"); 
		query.append(",      @[sr_sts_cd]" ).append("\n"); 
		query.append(",      'N'" ).append("\n"); 
		query.append(",      @[usr_id]" ).append("\n"); 
		query.append(",      DECODE(@[sr_sts_cd], 'SR', (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SF.CRE_DT, 'MYPKG')" ).append("\n"); 
		query.append("                          FROM BKG_SR_FAX SF " ).append("\n"); 
		query.append("                          WHERE SF.SR_KND_CD=RQ.SR_KND_CD " ).append("\n"); 
		query.append("                          AND  SF.SR_NO = RQ.SR_NO " ).append("\n"); 
		query.append("						  AND   SF.SR_KND_CD = 'F'" ).append("\n"); 
		query.append("						  AND   SF.FAX_LOG_REF_NO = RQ.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("                           ), GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG'))" ).append("\n"); 
		query.append(",      GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG')" ).append("\n"); 
		query.append(",      DECODE(@[sr_sts_cd],'ST',RQ.DIFF_RMK,NULL)" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append(",      @[usr_id]" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append(",      @[usr_id]" ).append("\n"); 
		query.append("FROM   BKG_SR_CRNT_RQST RQ" ).append("\n"); 
		query.append("WHERE  RQ.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND	   RQ.SR_KND_CD    = @[sr_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sr_sts_cd} == 'XX') " ).append("\n"); 
		query.append("AND    RQ.SR_NO   	<> @[sr_no]" ).append("\n"); 
		query.append("AND    SR_CRNT_STS_CD    <> 'XX'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND    RQ.SR_NO   	= @[sr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}