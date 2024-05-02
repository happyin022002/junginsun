/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSFoundAutoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.04 최민회
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

public class ChassisMgsetOnOffhireDBDAOsearchCHSFoundAutoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status가 'LST' 나 'TLL' 즉 손실된 장비에 해당하는 CHASSIS, 정보 조회
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSFoundAutoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSFoundAutoDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.EQ_NO" ).append("\n"); 
		query.append(", MAX(A.EQ_TPSZ_CD) AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(", MAX(A.AGMT_LSTM_CD) as AGMT_LSTM_CD" ).append("\n"); 
		query.append(", MAX(B.EQ_ASET_STS_CD) as EQ_ASET_STS_CD" ).append("\n"); 
		query.append(", MAX((SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = C.VNDR_SEQ)) as VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", MAX(TO_CHAR(B.STS_EVNT_DT,'YYYY-MM-DD HH24:MI')) as STS_EVNT_DT" ).append("\n"); 
		query.append(", MAX(B.CRE_USR_ID) as CRE_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", MIN(TO_CHAR(D.MVMT_DT,'YYYY-MM-DD HH24:MI:SS')) AS MVMT_DT" ).append("\n"); 
		query.append(", MIN(TO_CHAR(D.MVMT_DT,'YYYY-MM-DD HH24:MI')) as  MVMTS_DT" ).append("\n"); 
		query.append(", substr(MIN(TO_CHAR(D.MVMT_DT,'YYYY-MM-DD HH24:MI:SS')||D.MVMT_STS_CD  ),20,22)  as CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append(", substr(MIN(TO_CHAR(D.MVMT_DT,'YYYY-MM-DD HH24:MI:SS')|| D.YD_CD),20,27) as STS_EVNT_YD_CD" ).append("\n"); 
		query.append(", substr(MIN(TO_CHAR(D.MVMT_DT,'YYYY-MM-DD HH24:MI:SS')||D.SYS_SEQ) ,20,27) as SYS_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append(", CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append(", CGM_AGREEMENT C" ).append("\n"); 
		query.append(", CGM_CHSS_MVMT_HIS D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("AND A.EQ_KND_CD ='Z'" ).append("\n"); 
		query.append("AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND B.EQ_STS_SEQ = A.EQ_STS_SEQ" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD IN ('LST', 'TLL')" ).append("\n"); 
		query.append("AND B.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND B.AGMT_VER_NO = C.AGMT_VER_NO" ).append("\n"); 
		query.append("AND D.CHSS_NO = A.EQ_NO" ).append("\n"); 
		query.append("AND  D.MVMT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("AND  D.MVMT_DT > B.STS_EVNT_DT" ).append("\n"); 
		query.append("AND substr(D.YD_CD,0,5)  IN" ).append("\n"); 
		query.append("( SELECT AA.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION AA" ).append("\n"); 
		query.append(", MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY A.EQ_NO" ).append("\n"); 

	}
}