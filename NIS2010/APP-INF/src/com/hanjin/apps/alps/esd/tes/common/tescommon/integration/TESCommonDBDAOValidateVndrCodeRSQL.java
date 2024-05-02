/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TESCommonDBDAOValidateVndrCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOValidateVndrCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Validate Vendor Code
	  * </pre>
	  */
	public TESCommonDBDAOValidateVndrCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOValidateVndrCodeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    ( SELECT	CASE WHEN COUNT(VNDR_SEQ)>0 THEN 'Y' ELSE 'N' END VNDR_SEQ_EXISTING	" ).append("\n"); 
		query.append("        FROM	MDM_VENDOR " ).append("\n"); 
		query.append("        WHERE	VNDR_SEQ = @[vndr_seq]  " ).append("\n"); 
		query.append("        AND		DELT_FLG = 'N'" ).append("\n"); 
		query.append("    ) VNDR_SEQ_EXISTING" ).append("\n"); 
		query.append("    , VNDR_LGL_ENG_NM " ).append("\n"); 
		query.append("	, DECODE(IDA_GST_RGST_STS_CD,'R','Registered','U','Unregistered','C','Composite') IDA_GST_RGST_STS_CD" ).append("\n"); 
		query.append("    , IDA_GST_RGST_NO  " ).append("\n"); 
		query.append("    , (SELECT MS.IDA_STE_CD FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) IDA_STE_CD" ).append("\n"); 
		query.append("    , (SELECT MS.STE_NM FROM MDM_STATE MS WHERE MS.CNT_CD = 'IN' AND MS.STE_CD = ML.STE_CD AND ROWNUM = 1) IDA_STE_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE MV.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = @[vndr_seq]  " ).append("\n"); 
		query.append("AND	MV.DELT_FLG = 'N' " ).append("\n"); 

	}
}