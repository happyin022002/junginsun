/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi324SendDBDAOSearchEdi324EdiSendDetailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi324send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi324SendDBDAOSearchEdi324EdiSendDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP_NO을 기준으로 발송될 EDI의 상제 정보를 가져온다.
	  * </pre>
	  */
	public Edi324SendDBDAOSearchEdi324EdiSendDetailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi324send.integration").append("\n"); 
		query.append("FileName : Edi324SendDBDAOSearchEdi324EdiSendDetailInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(MV.LLOYD_NO, 'T.B.N.', 'TBN', 'T.B.N', 'TBN', MV.LLOYD_NO), ' ')  LLOYD_VSL_NO" ).append("\n"); 
		query.append(", NVL(REPLACE(MV.VSL_ENG_NM, CHR(39), ' '), ' ') VSL_NM" ).append("\n"); 
		query.append(", DT.NOD_CD POD_YD_CD" ).append("\n"); 
		query.append(", (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(DT.NOD_CD, 1,5)) POD_NM" ).append("\n"); 
		query.append(", DT.ACT_CD" ).append("\n"); 
		query.append(", TO_CHAR(DT.ESTM_DT,'YYYY-MM-DD HH24:MI:SS') POD_ESTM_ARR_DT" ).append("\n"); 
		query.append(", TO_CHAR(DT.ESTM_GDT,'YYYY-MM-DD HH24:MI:SS') POD_ESTM_ARR_GDT" ).append("\n"); 
		query.append(", (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = HD.BKG_NO) BL_NO" ).append("\n"); 
		query.append(", BK.CNTR_WGT CNTR_WGT" ).append("\n"); 
		query.append(", BK.WGT_UT_CD CNTR_WGT_UT_CD" ).append("\n"); 
		query.append(", ROUND((BK.CNTR_WGT * 2.2046),3) CNTR_LBS_WGT" ).append("\n"); 
		query.append(", BK.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", SIZ.CNTR_LEN" ).append("\n"); 
		query.append(", SIZ.CNTR_HGT" ).append("\n"); 
		query.append(", (SELECT REPLACE(NVL(CNTR_SEAL_NO, ' '), CHR(13)||CHR(10), '') FROM BKG_CNTR_SEAL_NO WHERE BKG_NO = HD.BKG_NO AND CNTR_NO = HD.CNTR_NO AND CNTR_SEAL_SEQ = 1) CNTR_SEAL_NO" ).append("\n"); 
		query.append(", ORG.YD_LOC_CTY_NM ORG_YD_LOC_CTY_NM" ).append("\n"); 
		query.append(", ORG.YD_LOC_STE_CD ORG_YD_LOC_STE_CD" ).append("\n"); 
		query.append(", ORG.LOC_NM ORG_LOC_NM" ).append("\n"); 
		query.append(", DST.YD_LOC_CTY_NM DST_YD_LOC_CTY_NM" ).append("\n"); 
		query.append(", DST.YD_LOC_STE_CD DST_YD_LOC_STE_CD" ).append("\n"); 
		query.append(", DST.LOC_NM DST_LOC_NM" ).append("\n"); 
		query.append(", BK.DCGO_FLG DG_FLG" ).append("\n"); 
		query.append(", HD.BKG_NO, HD.CNTR_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR HD" ).append("\n"); 
		query.append(", SCE_COP_DTL DT" ).append("\n"); 
		query.append(", MDM_VSL_CNTR MV" ).append("\n"); 
		query.append(", BKG_CONTAINER BK" ).append("\n"); 
		query.append(", (SELECT OMY.YD_CD, OMY.YD_LOC_CTY_NM, OMY.YD_LOC_STE_CD, OML.LOC_NM" ).append("\n"); 
		query.append("FROM MDM_YARD OMY, MDM_LOCATION OML" ).append("\n"); 
		query.append("WHERE OMY.LOC_CD = OML.LOC_CD" ).append("\n"); 
		query.append("AND OMY.YD_CD = @[org_yd_cd]" ).append("\n"); 
		query.append(") ORG" ).append("\n"); 
		query.append(", (SELECT DMY.YD_LOC_CTY_NM, DMY.YD_LOC_STE_CD, DML.LOC_NM" ).append("\n"); 
		query.append("FROM MDM_YARD DMY, MDM_LOCATION DML" ).append("\n"); 
		query.append("WHERE DMY.LOC_CD = DML.LOC_CD" ).append("\n"); 
		query.append("AND DMY.YD_CD = @[dest_yd_cd]" ).append("\n"); 
		query.append(") DST" ).append("\n"); 
		query.append(", (SELECT CNTR_TPSZ_CD, XTER_LEN CNTR_LEN, XTER_HGT CNTR_HGT" ).append("\n"); 
		query.append("FROM SCE_CNTR_SPEC" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append(") SIZ" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND HD.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND HD.COP_NO = DT.COP_NO" ).append("\n"); 
		query.append("AND DT.COP_DTL_SEQ = ( SELECT /*+ INDEX_DESC(A XPKSCE_COP_DTL) */ COP_DTL_SEQ" ).append("\n"); 
		query.append("FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("WHERE A.COP_NO = DT.COP_NO" ).append("\n"); 
		query.append("AND A.ACT_CD LIKE 'FU__A_'" ).append("\n"); 
		query.append("AND SUBSTR(A.ACT_CD,3,1) IN ( 'V','W' )" ).append("\n"); 
		query.append("AND A.COP_DTL_SEQ LIKE '4%'" ).append("\n"); 
		query.append("AND A.ACT_STS_CD IN('F','C','N')" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("AND DT.VSL_CD = MV.VSL_CD(+)" ).append("\n"); 
		query.append("AND HD.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("AND HD.CNTR_NO = BK.CNTR_NO(+)" ).append("\n"); 
		query.append("AND HD.CNTR_TPSZ_CD = SIZ.CNTR_TPSZ_CD(+)" ).append("\n"); 

	}
}