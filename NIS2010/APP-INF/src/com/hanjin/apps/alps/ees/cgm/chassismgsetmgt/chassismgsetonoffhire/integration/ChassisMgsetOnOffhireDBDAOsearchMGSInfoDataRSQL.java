/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.10.21 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis   Master 정보를 가져온다.
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSInfoDataRSQL(){
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
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSInfoDataRSQL").append("\n"); 
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
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",A.AGMT_LSTM_CD" ).append("\n"); 
		query.append(",A.ACIAC_DIV_CD" ).append("\n"); 
		query.append(",B.VNDR_SEQ" ).append("\n"); 
		query.append(",C.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(",D.EQ_ASET_STS_CD" ).append("\n"); 
		query.append(",A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(D.STS_EVNT_DT,'YYYY-MM-DD' ) STS_EVNT_DT" ).append("\n"); 
		query.append(",NVL((SELECT" ).append("\n"); 
		query.append("'O'" ).append("\n"); 
		query.append("FROM MST_CNTR_PRE_STS A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CNTR_STS_CD  = DECODE(A.ACIAC_DIV_CD,'A','LST','FND')" ).append("\n"); 
		query.append("AND A.CNTR_PRE_STS_CD =  D.EQ_ASET_STS_CD" ).append("\n"); 
		query.append("),'X' ) AS PRESTATUS" ).append("\n"); 
		query.append(",'' L_EVNT_DT" ).append("\n"); 
		query.append(",'' L_EVNT_YD_CD" ).append("\n"); 
		query.append(",'' F_EVNT_DT" ).append("\n"); 
		query.append(",'' F_EVNT_YD_CD" ).append("\n"); 
		query.append(",'' USER_ID" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT  A" ).append("\n"); 
		query.append(", CGM_AGREEMENT  B" ).append("\n"); 
		query.append(", MDM_VENDOR     C" ).append("\n"); 
		query.append(", CGM_EQ_STS_HIS D" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO     = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND B.VNDR_SEQ        = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND D.ROWID = (SELECT /*+ INDEX_DESC(C XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("ROWID" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS C" ).append("\n"); 
		query.append("WHERE C.EQ_NO= A.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 

	}
}