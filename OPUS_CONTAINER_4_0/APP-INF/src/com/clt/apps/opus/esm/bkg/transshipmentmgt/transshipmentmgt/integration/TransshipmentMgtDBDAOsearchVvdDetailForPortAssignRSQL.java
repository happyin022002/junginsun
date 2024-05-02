/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchVvdDetailForPortAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.03.22 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchVvdDetailForPortAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Booking VVD Detail for Group VVD/Port Assign
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchVvdDetailForPortAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchVvdDetailForPortAssignRSQL").append("\n"); 
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
		query.append("WITH SORTED_VVD AS ( " ).append("\n"); 
		query.append("	SELECT 	BKG_NO" ).append("\n"); 
		query.append("			,VSL_PRE_PST_CD" ).append("\n"); 
		query.append("			,VSL_SEQ" ).append("\n"); 
		query.append("			,RANK() OVER(PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ) AS VVD_ORDER" ).append("\n"); 
		query.append("        	,SLAN_CD" ).append("\n"); 
		query.append("			,VSL_CD" ).append("\n"); 
		query.append("			,SKD_VOY_NO" ).append("\n"); 
		query.append("			,SKD_DIR_CD" ).append("\n"); 
		query.append("			,OP_CD" ).append("\n"); 
		query.append("			,POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			,POL_CD" ).append("\n"); 
		query.append("			,POL_YD_CD" ).append("\n"); 
		query.append("			,POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("			,POD_CD" ).append("\n"); 
		query.append("			,POD_YD_CD" ).append("\n"); 
		query.append("	FROM BKG_VVD VVD" ).append("\n"); 
		query.append("	WHERE 0=0" ).append("\n"); 
		query.append("	AND EXISTS(" ).append("\n"); 
		query.append("		SELECT *" ).append("\n"); 
		query.append("		FROM BKG_VVD VVD_COND" ).append("\n"); 
		query.append("		INNER JOIN BKG_BOOKING BKG" ).append("\n"); 
		query.append("		ON VVD_COND.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("		WHERE VVD.BKG_NO=VVD_COND.BKG_NO" ).append("\n"); 
		query.append("		#if (${vvd}!='')" ).append("\n"); 
		query.append("			AND VVD_COND.VSL_CD = SUBSTR(@[vvd] ,1,4)" ).append("\n"); 
		query.append("			AND VVD_COND.SKD_VOY_NO = SUBSTR(@[vvd] ,5,4)" ).append("\n"); 
		query.append("			AND VVD_COND.SKD_DIR_CD = SUBSTR(@[vvd] ,9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		#if(${pol} !='')" ).append("\n"); 
		query.append("				AND VVD_COND.POL_CD = @[pol]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    		#if(${pol_yd_cd} !='')" ).append("\n"); 
		query.append("				AND SUBSTR(VVD_COND.POL_YD_CD,6,2) = @[pol_yd_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${pod}!='')" ).append("\n"); 
		query.append("				AND VVD_COND.POD_CD = @[pod]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("    		#if(${pod_yd_cd} !='')" ).append("\n"); 
		query.append("				AND SUBSTR(VVD_COND.POD_YD_CD,6,2) = @[pod_yd_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND BKG.BKG_STS_CD NOT IN ('X','S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("			AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#if (${bkgNos} != '')" ).append("\n"); 
		query.append("		AND VVD.BKG_NO IN (" ).append("\n"); 
		query.append("			#foreach($multiBkgNoVal IN ${bkgNos})        " ).append("\n"); 
		query.append("				#if($velocityCount < $bkgNos.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 	BKG.BKG_NO" ).append("\n"); 
		query.append("		,BKG.BL_NO" ).append("\n"); 
		query.append("		,BKG.POR_CD" ).append("\n"); 
		query.append("		,BKG.POR_NOD_CD" ).append("\n"); 
		query.append("		,BKG.POL_CD" ).append("\n"); 
		query.append("		,BKG.POL_NOD_CD" ).append("\n"); 
		query.append("		,BKG.POD_CD" ).append("\n"); 
		query.append("		,BKG.POD_NOD_CD" ).append("\n"); 
		query.append("		,BKG.DEL_CD" ).append("\n"); 
		query.append("		,BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("		,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("		,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("		,BKG.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("		,BKG.ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("		,BKG.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("		,TVVD.VSL_CD||TVVD.SKD_VOY_NO||TVVD.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append("		,TO_CHAR(BKG.MTY_PKUP_DT,'YYYY-MM-DD') MTY_PKUP_DT" ).append("\n"); 
		query.append("		,BKG.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("		,VVD1.POL_CD POL_CD1" ).append("\n"); 
		query.append("		,VVD1.POL_YD_CD POL_YD_CD1" ).append("\n"); 
		query.append("		,VVD1.POL_CLPT_IND_SEQ POL_CLPT_IND_SEQ1" ).append("\n"); 
		query.append("		,VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD VVD1" ).append("\n"); 
		query.append("		,VVD1.POD_CD POD_CD1" ).append("\n"); 
		query.append("		,VVD1.POD_YD_CD POD_YD_CD1" ).append("\n"); 
		query.append("		,VVD1.POD_CLPT_IND_SEQ POD_CLPT_IND_SEQ1" ).append("\n"); 
		query.append("		,VVD2.POL_CD POL_CD2" ).append("\n"); 
		query.append("		,VVD2.POL_YD_CD POL_YD_CD2" ).append("\n"); 
		query.append("		,VVD2.POL_CLPT_IND_SEQ POL_CLPT_IND_SEQ2" ).append("\n"); 
		query.append("		,VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD VVD2" ).append("\n"); 
		query.append("		,VVD2.POD_CD POD_CD2" ).append("\n"); 
		query.append("		,VVD2.POD_YD_CD POD_YD_CD2" ).append("\n"); 
		query.append("		,VVD2.POD_CLPT_IND_SEQ POD_CLPT_IND_SEQ2" ).append("\n"); 
		query.append("		,VVD3.POL_CD POL_CD3" ).append("\n"); 
		query.append("		,VVD3.POL_YD_CD POL_YD_CD3" ).append("\n"); 
		query.append("		,VVD3.POL_CLPT_IND_SEQ POL_CLPT_IND_SEQ3" ).append("\n"); 
		query.append("		,VVD3.VSL_CD||VVD3.SKD_VOY_NO||VVD3.SKD_DIR_CD VVD3" ).append("\n"); 
		query.append("		,VVD3.POD_CD POD_CD3" ).append("\n"); 
		query.append("		,VVD3.POD_YD_CD POD_YD_CD3" ).append("\n"); 
		query.append("		,VVD3.POD_CLPT_IND_SEQ POD_CLPT_IND_SEQ3" ).append("\n"); 
		query.append("		,VVD4.POL_CD POL_CD4" ).append("\n"); 
		query.append("		,VVD4.POL_YD_CD POL_YD_CD4" ).append("\n"); 
		query.append("		,VVD4.POL_CLPT_IND_SEQ POL_CLPT_IND_SEQ4" ).append("\n"); 
		query.append("		,VVD4.VSL_CD||VVD4.SKD_VOY_NO||VVD4.SKD_DIR_CD VVD4" ).append("\n"); 
		query.append("		,VVD4.POD_CD POD_CD4" ).append("\n"); 
		query.append("		,VVD4.POD_YD_CD POD_YD_CD4" ).append("\n"); 
		query.append("		,VVD4.POD_CLPT_IND_SEQ POD_CLPT_IND_SEQ4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,NVL(BKG.POR_CD,'')||'|'||NVL(BKG.POL_NOD_CD,'')||'|'||NVL(BKG.POD_NOD_CD,'')||'|'||NVL(BKG.DEL_CD,'')" ).append("\n"); 
		query.append("         ||'|'||NVL(TVVD.VSL_CD,'')||NVL(TVVD.SKD_VOY_NO,'')||NVL(TVVD.SKD_DIR_CD,'')" ).append("\n"); 
		query.append("		 ||'|'||NVL(PRE.VSL_CD,'')||NVL(PRE.SKD_VOY_NO,'')||NVL(PRE.SKD_DIR_CD,'')||'|'||NVL(PRE.POD_YD_CD,'')" ).append("\n"); 
		query.append("		 ||'|'||NVL(POST.VSL_CD,'')||NVL(POST.SKD_VOY_NO,'')||NVL(POST.SKD_DIR_CD,'')||'|'||NVL(POST.POL_YD_CD,'')" ).append("\n"); 
		query.append("		 ROUTE_KEY" ).append("\n"); 
		query.append("		,       NVL(VVD1.POL_YD_CD,'')||'|'||NVL(VVD1.VSL_CD||VVD1.SKD_VOY_NO||VVD1.SKD_DIR_CD,'')||'|'||VVD1.POD_YD_CD" ).append("\n"); 
		query.append("         ||'|'||NVL(VVD2.POL_YD_CD,'')||'|'||NVL(VVD2.VSL_CD||VVD2.SKD_VOY_NO||VVD2.SKD_DIR_CD,'')||'|'||VVD2.POD_YD_CD" ).append("\n"); 
		query.append("         ||'|'||NVL(VVD3.POL_YD_CD,'')||'|'||NVL(VVD3.VSL_CD||VVD3.SKD_VOY_NO||VVD3.SKD_DIR_CD,'')||'|'||VVD3.POD_YD_CD" ).append("\n"); 
		query.append("         ||'|'||NVL(VVD4.POL_YD_CD,'')||'|'||NVL(VVD4.VSL_CD||VVD4.SKD_VOY_NO||VVD4.SKD_DIR_CD,'')||'|'||VVD4.POD_YD_CD" ).append("\n"); 
		query.append("		 VVD_KEY" ).append("\n"); 
		query.append("		,CASE WHEN VVD1.VSL_PRE_PST_CD = 'T' THEN '1'" ).append("\n"); 
		query.append("		      WHEN VVD2.VSL_PRE_PST_CD = 'T' THEN '2'" ).append("\n"); 
		query.append("		      WHEN VVD3.VSL_PRE_PST_CD = 'T' THEN '3'" ).append("\n"); 
		query.append("		      WHEN VVD4.VSL_PRE_PST_CD = 'T' THEN '4'" ).append("\n"); 
		query.append("		      ELSE '' END TVVD_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SORTED_VVD VVD1" ).append("\n"); 
		query.append("INNER JOIN BKG_BOOKING BKG" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO=BKG.BKG_NO" ).append("\n"); 
		query.append("INNER JOIN SORTED_VVD TVVD" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO = TVVD.BKG_NO" ).append("\n"); 
		query.append("	AND TVVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("LEFT OUTER JOIN SORTED_VVD VVD2" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("	AND VVD2.VVD_ORDER = 2" ).append("\n"); 
		query.append("LEFT OUTER JOIN SORTED_VVD VVD3" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO = VVD3.BKG_NO" ).append("\n"); 
		query.append("	AND VVD3.VVD_ORDER = 3" ).append("\n"); 
		query.append("LEFT OUTER JOIN SORTED_VVD VVD4" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO = VVD4.BKG_NO" ).append("\n"); 
		query.append("	AND VVD4.VVD_ORDER = 4" ).append("\n"); 
		query.append("LEFT OUTER JOIN SORTED_VVD PRE" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO = PRE.BKG_NO" ).append("\n"); 
		query.append("	AND PRE.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("	AND TVVD.POL_CD = PRE.POD_CD" ).append("\n"); 
		query.append("LEFT OUTER JOIN SORTED_VVD POST" ).append("\n"); 
		query.append("	ON VVD1.BKG_NO = POST.BKG_NO" ).append("\n"); 
		query.append("	AND POST.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("	AND TVVD.POD_CD = POST.POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND VVD1.VVD_ORDER = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("	BKG.POR_CD" ).append("\n"); 
		query.append("	,BKG.POL_NOD_CD" ).append("\n"); 
		query.append("	,BKG.POD_NOD_CD" ).append("\n"); 
		query.append("	,BKG.DEL_CD" ).append("\n"); 
		query.append("	,NVL(TVVD.VSL_CD,'')||NVL(TVVD.SKD_VOY_NO,'')||NVL(TVVD.SKD_DIR_CD,'')" ).append("\n"); 
		query.append("	,NVL(PRE.VSL_CD,'')||NVL(PRE.SKD_VOY_NO,'')||NVL(PRE.SKD_DIR_CD,'')" ).append("\n"); 
		query.append("	,NVL(PRE.POD_YD_CD,'')" ).append("\n"); 
		query.append("	,NVL(POST.VSL_CD,'')||NVL(POST.SKD_VOY_NO,'')||NVL(POST.SKD_DIR_CD,'')" ).append("\n"); 
		query.append("	,NVL(POST.POL_YD_CD,'')" ).append("\n"); 
		query.append("	,BKG.BKG_NO" ).append("\n"); 

	}
}