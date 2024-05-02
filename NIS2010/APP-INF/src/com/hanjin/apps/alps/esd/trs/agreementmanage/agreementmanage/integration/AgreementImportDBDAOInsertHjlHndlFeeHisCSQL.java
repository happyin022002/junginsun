/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementImportDBDAOInsertHjlHndlFeeHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2012.06.14 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOInsertHjlHndlFeeHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.24 신동일 [CHM-201217633] HJL Handling Fee History
	  * </pre>
	  */
	public AgreementImportDBDAOInsertHjlHndlFeeHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("hjl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOInsertHjlHndlFeeHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_HJL_HNDL_FEE_HIS" ).append("\n"); 
		query.append("SELECT C.HJL_OFC_CD" ).append("\n"); 
		query.append(",(SELECT NVL (HNDL_FEE_HIS_SEQ + 1, 1)" ).append("\n"); 
		query.append("FROM (SELECT B.HNDL_FEE_HIS_SEQ" ).append("\n"); 
		query.append("FROM TRS_HJL_HNDL_FEE A" ).append("\n"); 
		query.append(",TRS_HJL_HNDL_FEE_HIS B" ).append("\n"); 
		query.append("WHERE A.HJL_OFC_CD = B.HJL_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.HJL_OFC_CD = @[hjl_ofc_cd]" ).append("\n"); 
		query.append("ORDER BY B.HNDL_FEE_HIS_SEQ DESC)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1) HNDL_FEE_HIS_SEQ" ).append("\n"); 
		query.append(",C.VNDR_SEQ" ).append("\n"); 
		query.append(",C.CURR_CD" ).append("\n"); 
		query.append(",C.COST_RCVR_AMT" ).append("\n"); 
		query.append(",C.COMM_AMT" ).append("\n"); 
		query.append(",C.TTL_AMT" ).append("\n"); 
		query.append(",C.EFF_FM_DT" ).append("\n"); 
		query.append(",(TO_DATE (@[eff_fm_dt],'YYYYMMDD') - 1 )+0.99999 EFF_TO_DT" ).append("\n"); 
		query.append(",C.CRE_USR_ID" ).append("\n"); 
		query.append(",C.CRE_DT" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("FROM TRS_HJL_HNDL_FEE C" ).append("\n"); 
		query.append("WHERE C.HJL_OFC_CD = @[hjl_ofc_cd]" ).append("\n"); 

	}
}