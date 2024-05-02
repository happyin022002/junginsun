/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementImportDBDAOUpdateHjlHndlFeeUSQL.java
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

public class AgreementImportDBDAOUpdateHjlHndlFeeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.24 신동일 [CHM-201217633] HJL Handling Fee 수정
	  * </pre>
	  */
	public AgreementImportDBDAOUpdateHjlHndlFeeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_rcvr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOUpdateHjlHndlFeeUSQL").append("\n"); 
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
		query.append("UPDATE TRS_HJL_HNDL_FEE" ).append("\n"); 
		query.append("SET VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(",CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append(",COST_RCVR_AMT = @[cost_rcvr_amt]" ).append("\n"); 
		query.append(",COMM_AMT = @[comm_amt]" ).append("\n"); 
		query.append(",TTL_AMT = @[ttl_amt]" ).append("\n"); 
		query.append(",EFF_FM_DT = TO_DATE(REPLACE(@[eff_fm_dt],'-',''),'YYYYMMDD')+0.00000" ).append("\n"); 
		query.append(",CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",CRE_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(",UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("WHERE HJL_OFC_CD=  @[hjl_ofc_cd]" ).append("\n"); 

	}
}