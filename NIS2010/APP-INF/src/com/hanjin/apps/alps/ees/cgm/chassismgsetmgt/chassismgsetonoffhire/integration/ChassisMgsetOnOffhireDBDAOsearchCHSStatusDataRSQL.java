/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.16 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchCHSStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis Status Inquiry/Correction 조회   
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSStatusDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append(",A.EQ_STS_SEQ" ).append("\n"); 
		query.append(",A.EQ_ASET_STS_CD" ).append("\n"); 
		query.append(",to_char(A.STS_EVNT_DT,'yyyy-mm-dd HH24:MI') STS_EVNT_DT" ).append("\n"); 
		query.append(",to_char(A.CRE_DT,'yyyy-mm-dd HH24:MI') CRE_DT" ).append("\n"); 
		query.append(",A.STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(",A.STS_EVNT_YD_CD" ).append("\n"); 
		query.append(",A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",LPAD(A.AGMT_SEQ  , 6, '0'    ) AGMT_SEQ" ).append("\n"); 
		query.append(", A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ  , 6, '0'    ) AGREEEMENT" ).append("\n"); 
		query.append(",B.AGMT_REF_NO" ).append("\n"); 
		query.append(",C.VNDR_SEQ" ).append("\n"); 
		query.append(",C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",D.ACIAC_DIV_CD" ).append("\n"); 
		query.append(",DECODE(D.ACIAC_DIV_CD,'A','active','I','In-active') ACIAC_DIV_NM" ).append("\n"); 
		query.append(",D.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",D.AGMT_LSTM_CD" ).append("\n"); 
		query.append(",A.TERM_CNG_SEQ" ).append("\n"); 
		query.append(",D.CRNT_YD_CD" ).append("\n"); 
		query.append(",D.CRNT_LOC_CD" ).append("\n"); 
		query.append(",D.ONH_OFC_CD" ).append("\n"); 
		query.append(",D.ONH_DT" ).append("\n"); 
		query.append(",D.ONH_YD_CD" ).append("\n"); 
		query.append(",D.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",D.AGMT_VER_NO" ).append("\n"); 
		query.append(",'' NO" ).append("\n"); 
		query.append(",case WHEN (sysdate - A.STS_EVNT_DT) >180 then" ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append("else" ).append("\n"); 
		query.append("'N'" ).append("\n"); 
		query.append("end chk_val" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS A" ).append("\n"); 
		query.append(",CGM_AGREEMENT  B" ).append("\n"); 
		query.append(",MDM_VENDOR     C" ).append("\n"); 
		query.append(",CGM_EQUIPMENT D" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD       ='Z'" ).append("\n"); 
		query.append("AND A.AGMT_SEQ        = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO     = B.AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND B.VNDR_SEQ        = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.EQ_NO           = D.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD       = B.EQ_KND_CD(+)" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("--ORDER BY A.EQ_NO ,A.EQ_STS_SEQ" ).append("\n"); 
		query.append("ORDER BY A.STS_EVNT_DT, A.EQ_STS_SEQ" ).append("\n"); 

	}
}