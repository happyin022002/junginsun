/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CgmValidationDBDAOsearchCNTRMasterDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.16
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.08.16 이석준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Joon(Suk-Joon) LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmValidationDBDAOsearchCNTRMasterDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CgmValidationDBDAOsearchCNTRMasterDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration").append("\n"); 
		query.append("FileName : CgmValidationDBDAOsearchCNTRMasterDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(b XAK1CGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("       A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("      ,DECODE(TO_CHAR(B.DTCH_DT,'YYYYMMDD'),NULL,'DT','88881231','AT','DT') disp_flg" ).append("\n"); 
		query.append("      ,B.EQ_NO" ).append("\n"); 
		query.append("      ,B.EQ_KND_CD" ).append("\n"); 
		query.append("#if ( ${onh_yd_cd} != '' )" ).append("\n"); 
		query.append("      ,( SELECT B.DTCH_YD_CD FROM CGM_EQ_ATCH_DTCH_HIS B WHERE CNTR_NO= A.CNTR_NO" ).append("\n"); 
		query.append("     AND DTCH_YD_CD IS  NULL AND ROWNUM = 1) ONH_YD_CD   " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("FROM MST_CONTAINER A ,CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = B.CNTR_no(+)" ).append("\n"); 
		query.append("  AND A.CNTR_NO =  @[cntr_no]" ).append("\n"); 
		query.append("  AND ROWNUM =1" ).append("\n"); 

	}
}