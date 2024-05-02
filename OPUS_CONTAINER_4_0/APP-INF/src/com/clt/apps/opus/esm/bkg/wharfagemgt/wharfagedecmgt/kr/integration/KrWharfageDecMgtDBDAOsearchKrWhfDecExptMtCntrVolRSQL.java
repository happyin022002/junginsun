/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecExptMtCntrVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfDecExptMtCntrVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfDecExptMtCntrVolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("size_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfDecExptMtCntrVolRSQL").append("\n"); 
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
		query.append("SELECT SUM(CASE WHEN @[size_id] = '20' AND SUBSTR(CCCC.CNTR_TPSZ_CD, 2, 1) = '2' THEN CCCC.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                WHEN @[size_id] = '40' AND SUBSTR(CCCC.CNTR_TPSZ_CD, 2, 1) IN ('4', '5') THEN CCCC.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                WHEN @[size_id] = '45' AND SUBSTR(CCCC.CNTR_TPSZ_CD, 2, 1) NOT IN ('2', '4', '5') THEN CCCC.CNTR_VOL_QTY" ).append("\n"); 
		query.append("           END) AS MT_QTY" ).append("\n"); 
		query.append("  FROM (SELECT BBB.BKG_NO, BBB.CSTMS_DECL_TP_CD, MAX(TRNS_SEQ) TRNS_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT BB.VSL_CD, BB.SKD_VOY_NO, BB.SKD_DIR_CD" ).append("\n"); 
		query.append("                  FROM (SELECT A.MRN_NO, A.MRN_CHK_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, A.PORT_CD, A.OB_DECL_TP_CD, MAX(A.VVD_SEQ) AS VVD_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_KR_VVD_SMRY A" ).append("\n"); 
		query.append("                         WHERE A.MRN_NO = SUBSTR(@[mrn], 1, 10)" ).append("\n"); 
		query.append("                           AND A.MRN_CHK_NO = SUBSTR(@[mrn], 11, 1)" ).append("\n"); 
		query.append("                           AND A.IO_BND_CD = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("                           AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                         GROUP BY A.MRN_NO, A.MRN_CHK_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD, A.PORT_CD, A.OB_DECL_TP_CD) AA," ).append("\n"); 
		query.append("                       BKG_CSTMS_KR_VVD_SMRY BB" ).append("\n"); 
		query.append("                 WHERE BB.MRN_NO = AA.MRN_NO" ).append("\n"); 
		query.append("                   AND BB.MRN_CHK_NO = AA.MRN_CHK_NO" ).append("\n"); 
		query.append("                   AND BB.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("                   AND BB.SKD_VOY_NO = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND BB.SKD_DIR_CD = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND BB.IO_BND_CD = AA.IO_BND_CD" ).append("\n"); 
		query.append("                   AND BB.PORT_CD = AA.PORT_CD" ).append("\n"); 
		query.append("                   AND BB.OB_DECL_TP_CD = AA.OB_DECL_TP_CD" ).append("\n"); 
		query.append("                   AND BB.VVD_SEQ = AA.VVD_SEQ) AAA," ).append("\n"); 
		query.append("               BKG_CSTMS_KR_BL BBB," ).append("\n"); 
		query.append("               MDM_LOCATION CCC" ).append("\n"); 
		query.append("         WHERE BBB.VSL_CD = AAA.VSL_CD" ).append("\n"); 
		query.append("           AND BBB.SKD_VOY_NO = AAA.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BBB.SKD_DIR_CD = AAA.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BBB.DELT_FLG != 'Y'" ).append("\n"); 
		query.append("           AND DECODE(@[whf_bnd_cd], 'II', BBB.TS_POD_CD, BBB.TS_POL_CD) = @[port_cd]" ).append("\n"); 
		query.append("           AND BBB.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("           AND CCC.LOC_CD = @[port_cd]" ).append("\n"); 
		query.append("         GROUP BY BBB.BKG_NO, BBB.CSTMS_DECL_TP_CD) AAAA, BKG_CSTMS_KR_BL BBBB," ).append("\n"); 
		query.append("       BKG_CONTAINER CCCC" ).append("\n"); 
		query.append(" WHERE BBBB.BKG_NO = AAAA.BKG_NO" ).append("\n"); 
		query.append("   AND BBBB.CSTMS_DECL_TP_CD = AAAA.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("   AND BBBB.TRNS_SEQ = AAAA.TRNS_SEQ" ).append("\n"); 
		query.append("   AND CCCC.BKG_NO = BBBB.BKG_NO" ).append("\n"); 

	}
}