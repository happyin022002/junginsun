/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchCodHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.20 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Yeoung Hee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchCodHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cod 요청에 대한 변경 이력을 조회한다
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchCodHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchCodHistoryRSQL").append("\n"); 
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
		query.append("select (select now.COD_STS_CD || ' : ' || INTG_CD_VAL_DP_DESC from com_intg_cd_dtl where INTG_CD_ID = 'CD02124' and INTG_CD_VAL_CTNT = now.COD_STS_CD) now" ).append("\n"); 
		query.append(", (select pre.COD_STS_CD || ' : ' || INTG_CD_VAL_DP_DESC from com_intg_cd_dtl where INTG_CD_ID = 'CD02124' and INTG_CD_VAL_CTNT = pre.COD_STS_CD) pre" ).append("\n"); 
		query.append(", now.UPD_USR_ID" ).append("\n"); 
		query.append(", (select usr_nm from com_user where usr_id = now.upd_usr_id) usr_nm" ).append("\n"); 
		query.append(", now.ISS_OFC_CD" ).append("\n"); 
		query.append(", TO_CHAR(now.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(", now.bkg_no" ).append("\n"); 
		query.append("from bkg_cod_his now, bkg_cod_his pre" ).append("\n"); 
		query.append("where now.bkg_no       = pre.bkg_no        (+)" ).append("\n"); 
		query.append("and now.cod_rqst_seq = pre.cod_rqst_seq  (+)" ).append("\n"); 
		query.append("and now.cod_his_seq  = pre.cod_his_seq   (+) + 1" ).append("\n"); 
		query.append("#if (${bkg_no} !='' )" ).append("\n"); 
		query.append("and now.bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cod_rqst_seq} !='' )" ).append("\n"); 
		query.append("and now.cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by upd_dt" ).append("\n"); 

	}
}