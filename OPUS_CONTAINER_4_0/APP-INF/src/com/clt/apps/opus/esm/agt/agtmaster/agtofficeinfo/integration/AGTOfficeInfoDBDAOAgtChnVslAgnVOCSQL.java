/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeInfoDBDAOAgtChnVslAgnVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.02.19 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeInfoDBDAOAgtChnVslAgnVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTOfficeInfoDBDAOAgtChnVslAgnVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_finc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeInfoDBDAOAgtChnVslAgnVOCSQL").append("\n"); 
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
		query.append("INSERT INTO AGT_CHN_VSL_AGN (VSL_CD," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("AGN_CUST_CNT_CD," ).append("\n"); 
		query.append("AGN_CUST_SEQ," ).append("\n"); 
		query.append("AGN_FINC_OFC_CD," ).append("\n"); 
		query.append("AGN_VNDR_CNT_CD," ).append("\n"); 
		query.append("AGN_VNDR_SEQ," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[vsl_cd],    -- Parameter 1" ).append("\n"); 
		query.append("@[agn_cd],   -- Parameter 2" ).append("\n"); 
		query.append("@[agn_cnt_cd],      -- Parameter 3 ('CN101962'.substring(0, 2))" ).append("\n"); 
		query.append("@[agn_cust_seq],    -- Parameter 3 ('CN101962'.substring(2))(integer cast)" ).append("\n"); 
		query.append("@[agn_finc_ofc_cd],   -- Parameter 4" ).append("\n"); 
		query.append("(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[agn_vndr_seq]),      -- Parameter 5" ).append("\n"); 
		query.append("@[agn_vndr_seq],     -- Parameter 6 (integer cast)" ).append("\n"); 
		query.append("@[delt_flg],       -- Parameter 7" ).append("\n"); 
		query.append("@[cre_usr_id], -- Parameter 8 (event.gerUserId)" ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id], -- Parameter 8 (event.gerUserId)" ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}