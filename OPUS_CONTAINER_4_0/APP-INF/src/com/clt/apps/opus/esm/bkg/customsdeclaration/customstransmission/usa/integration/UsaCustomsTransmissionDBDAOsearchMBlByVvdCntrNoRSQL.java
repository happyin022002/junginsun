/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchMBlByVvdCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.03 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchMBlByVvdCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaResultCntrVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchMBlByVvdCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchMBlByVvdCntrNoRSQL").append("\n"); 
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
		query.append("SELECT I.BL_NO in_bl" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL I" ).append("\n"); 
		query.append(", BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append(", MDM_VSL_CNTR V" ).append("\n"); 
		query.append("WHERE I.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND I.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND I.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[in_cntr]" ).append("\n"); 
		query.append("AND I.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("AND V.VSL_ENG_NM LIKE TRIM(@[vsl_eng_nm_m])||'%'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}