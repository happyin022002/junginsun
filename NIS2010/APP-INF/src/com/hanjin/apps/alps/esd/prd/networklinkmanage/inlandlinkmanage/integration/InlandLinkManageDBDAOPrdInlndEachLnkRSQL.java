/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandLinkManageDBDAOPrdInlndEachLnkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.03.17 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOPrdInlndEachLnkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdInlndEachLnk
	  * </pre>
	  */
	public InlandLinkManageDBDAOPrdInlndEachLnkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOPrdInlndEachLnkRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR (l.lnk_org_nod_cd, 1, 5) org_loc,                            " ).append("\n"); 
		query.append("			        SUBSTR (l.lnk_org_nod_cd, 6) org_type,                              " ).append("\n"); 
		query.append("			        SUBSTR (l.lnk_dest_nod_cd, 1, 5) dest_loc,                          " ).append("\n"); 
		query.append("			        SUBSTR (l.lnk_dest_nod_cd, 6) dest_type, l.trsp_mod_cd, l.vndr_seq, " ).append("\n"); 
		query.append("			        v.vndr_cnt_cd, (v.vndr_cnt_cd||l.vndr_seq) sp_cd,                   " ).append("\n"); 
		query.append("			        v.VNDR_LGL_ENG_NM vndr_name,                                           " ).append("\n"); 
		query.append("			 trim(to_char(trunc(l.tztm_hrs/24,0),'00'))||trim(to_char(mod(l.tztm_hrs,24  ),'00')) fmt_tztm_hrs ,  " ).append("\n"); 
		query.append("			        l.lnk_dist, l.dist_ut_cd, l.rail_crr_tp_cd,                         " ).append("\n"); 
		query.append("			        l.lnk_org_nod_cd, l.lnk_dest_nod_cd ,l.tztm_hrs ,                   " ).append("\n"); 
		query.append("		       CASE																	 " ).append("\n"); 
		query.append("		          WHEN SUBSTR (l.lnk_org_nod_cd, 1, 2) IN ('US', 'CA' )            " ).append("\n"); 
		query.append("		           AND SUBSTR (l.lnk_dest_nod_cd, 1, 2) IN ('US', 'CA' )           	" ).append("\n"); 
		query.append("		           AND l.trsp_mod_cd = 'RD'                                             " ).append("\n"); 
		query.append("		             THEN 'T'                                                           " ).append("\n"); 
		query.append("		          ELSE 'F'                                                              " ).append("\n"); 
		query.append("		       END fc,                                                                   " ).append("\n"); 
		query.append("		       a.TRSP_AGMT_OFC_CTY_CD, a.TRSP_AGMT_SEQ,  " ).append("\n"); 
		query.append("		       l.TRSP_AGMT_OFC_CTY_CD||lpad(l.TRSP_AGMT_SEQ,6,'0') agmt_no,  a.AGMT_REF_NO   " ).append("\n"); 
		query.append("		    " ).append("\n"); 
		query.append("		       --,AV.VNDR_SEQ,  " ).append("\n"); 
		query.append(" 				," ).append("\n"); 
		query.append("		     CASE                                                                               " ).append("\n"); 
		query.append("		         WHEN  l.TRSP_AGMT_OFC_CTY_CD IS NULL AND l.TRSP_AGMT_SEQ IS NULL THEN 'NOT'    " ).append("\n"); 
		query.append("		         WHEN  l.TRSP_AGMT_OFC_CTY_CD IS NOT NULL AND l.TRSP_AGMT_SEQ IS NOT NULL THEN  " ).append("\n"); 
		query.append("		             CASE                                                                       " ).append("\n"); 
		query.append("		                 WHEN NVL(l.TRSP_AGMT_OFC_CTY_CD,'X') = NVL(A.TRSP_AGMT_OFC_CTY_CD,'X')  " ).append("\n"); 
		query.append("		                 AND NVL(to_char(l.TRSP_AGMT_SEQ),'X') = NVL(to_char(A.TRSP_AGMT_SEQ),'X')                " ).append("\n"); 
		query.append("		                 AND l.vndr_seq <> AV.VNDR_SEQ  THEN 'OK'                               " ).append("\n"); 
		query.append("		                 ELSE 'NOT'                                                             " ).append("\n"); 
		query.append("		             END                                                                        " ).append("\n"); 
		query.append("		         ELSE 'NOT'                                                                     " ).append("\n"); 
		query.append("		     END  UNMATCH                                                                       		    " ).append("\n"); 
		query.append("			 FROM prd_inlnd_each_lnk l" ).append("\n"); 
		query.append("                 left outer join mdm_vendor v" ).append("\n"); 
		query.append("                 on (l.vndr_seq = v.vndr_seq)" ).append("\n"); 
		query.append("                 left outer join TRS_AGMT_HDR a" ).append("\n"); 
		query.append("                 on (l.TRSP_AGMT_OFC_CTY_CD = a.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                     AND l.TRSP_AGMT_SEQ = a.TRSP_AGMT_SEQ )" ).append("\n"); 
		query.append("                 left outer join TRS_AGMT_APLY_VNDR AV" ).append("\n"); 
		query.append("                 on ( A.TRSP_AGMT_OFC_CTY_CD = AV.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			          AND A.TRSP_AGMT_SEQ = AV.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                      AND L.VNDR_SEQ = AV.VNDR_SEQ) -- vendor 추가 mgpark 20110317" ).append("\n"); 
		query.append("			 WHERE l.lnk_org_nod_cd LIKE @[i_org_cd] || '%'                                      " ).append("\n"); 
		query.append("			    AND l.lnk_dest_nod_cd LIKE @[i_dest_cd] || '%'                                     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			    AND nvl(l.TRSP_AGMT_OFC_CTY_CD,'X') like @[cty_cd] ||'%'    " ).append("\n"); 
		query.append("                AND nvl(TO_CHAR(l.TRSP_AGMT_SEQ),'X') LIKE decode(@[agmt_seq],'0','', @[agmt_seq] ) ||'%' " ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			    AND nvl(l.delt_flg,'N')<>'Y'                " ).append("\n"); 
		query.append("--			    AND l.vndr_seq = v.vndr_seq(+)                                           " ).append("\n"); 
		query.append("--			    AND l.TRSP_AGMT_OFC_CTY_CD = a.TRSP_AGMT_OFC_CTY_CD(+)                   " ).append("\n"); 
		query.append("--			    AND l.TRSP_AGMT_SEQ = a.TRSP_AGMT_SEQ(+)                                 " ).append("\n"); 
		query.append("--			  --  AND   NVL(a.DELT_FLG, 'N')   = 'N' " ).append("\n"); 
		query.append("--			    AND A.TRSP_AGMT_OFC_CTY_CD = AV.TRSP_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("--			    AND A.TRSP_AGMT_SEQ = AV.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                AND l.VNDR_SEQ <> '6257' -- 해당 vender_code 제외" ).append("\n"); 

	}
}