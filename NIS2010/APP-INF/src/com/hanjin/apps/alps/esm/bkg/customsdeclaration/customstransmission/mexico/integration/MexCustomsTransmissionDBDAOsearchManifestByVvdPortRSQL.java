/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchManifestByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchManifestByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0370, 멕시코 세관 신고 조회용, outVO : MxManifestListByVvdDetailVO extends ManifestTransmitVO
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchManifestByVvdPortRSQL(){
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
		params.put("search_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchManifestByVvdPortRSQL").append("\n"); 
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
		query.append("SELECT NVL(BV.VSL_CD,' ')||NVL(BV.SKD_VOY_NO,' ')||NVL(BV.SKD_DIR_CD,' ') vvd," ).append("\n"); 
		query.append("		BKG.BKG_NO ,BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD," ).append("\n"); 
		query.append("		NVL(BKG.BL_NO,' ') bl_no, " ).append("\n"); 
		query.append("		NVL(BKG.RCV_TERM_CD, ' ') r," ).append("\n"); 
		query.append("		NVL(BKG.DE_TERM_CD, ' ') d," ).append("\n"); 
		query.append("		DECODE(BV.POL_CD, 'MXESE', DECODE(BKG.POL_CD, 'MXESE', 'L', 'T')," ).append("\n"); 
		query.append("		DECODE(BV.POD_CD, 'MXESE', DECODE(BKG.POD_CD, 'MXESE', 'L', 'T'), ' ')) ts," ).append("\n"); 
		query.append("		BKG.POR_CD, BV.POL_CD, BV.POD_CD, BKG.DEL_CD, BKG.STWG_CD," ).append("\n"); 
		query.append("		DOC.ACT_WGT, DOC.WGT_UT_CD," ).append("\n"); 
		query.append("		DOC.PCK_QTY," ).append("\n"); 
		query.append("		NVL(BR.FRT_TERM_CD, ' ') FRT_TERM_CD," ).append("\n"); 
		query.append("		DECODE(BKG.HOT_DE_FLG, 'Y', 'H', ' ') HOT_DE_FLG," ).append("\n"); 
		query.append("		DECODE(BKG.RC_FLG, 'Y', 'R', ' ') RC_FLG," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(SND_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("            WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND   HIS_SEQ = (" ).append("\n"); 
		query.append("                                SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                AND EDI_ID = 'MEXCUS'" ).append("\n"); 
		query.append("                            )        " ).append("\n"); 
		query.append("        ) SND_DT," ).append("\n"); 
		query.append("		CD.INTG_CD_VAL_DP_DESC STWG_DESC," ).append("\n"); 
		query.append("		'' USR_ID, '' OFC_CD, BKG.BL_NO o_bl_no," ).append("\n"); 
		query.append("		@[pol_cd] cpol," ).append("\n"); 
		query.append("		@[pod_cd] cpod" ).append("\n"); 
		query.append("	FROM  BKG_BOOKING BKG, BKG_BL_DOC DOC, BKG_RATE BR" ).append("\n"); 
		query.append("		, BKG_VVD BV, COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("	WHERE BV.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND BV.SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND BV.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("	AND BKG.BKG_NO       = BV.BKG_NO " ).append("\n"); 
		query.append("	AND BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("    AND BV.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_flg} == 'O')" ).append("\n"); 
		query.append("	AND BV.POL_CD LIKE 'MX%'" ).append("\n"); 
		query.append("	AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${search_flg} == 'I')" ).append("\n"); 
		query.append("		AND BV.POD_CD LIKE 'MX%'" ).append("\n"); 
		query.append("		AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND (BV.POD_CD LIKE 'MX%' OR BV.POL_CD LIKE 'MX%')" ).append("\n"); 
		query.append("		AND BV.VSL_PRE_PST_CD <> 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("        AND BV.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND @[search_flg] = @[search_flg]  " ).append("\n"); 
		query.append("	AND (BKG.BKG_STS_CD ='F' OR BKG.BKG_STS_CD = 'W') " ).append("\n"); 
		query.append("#if(${search_cargo} == 'F')" ).append("\n"); 
		query.append("  AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("  AND BKG.BKG_NO      = DOC.BKG_NO" ).append("\n"); 
		query.append("  AND BKG.BKG_NO      = BR.BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("  AND BKG.BKG_NO      = DOC.BKG_NO(+) " ).append("\n"); 
		query.append("  AND BKG.BKG_NO      = BR.BKG_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND BKG.STWG_CD		= CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("	AND CD.INTG_CD_ID(+)= 'CD02146'" ).append("\n"); 
		query.append("GROUP BY NVL(BV.VSL_CD,' ')||NVL(BV.SKD_VOY_NO,' ')||NVL(BV.SKD_DIR_CD,' ') ," ).append("\n"); 
		query.append("	BKG.BKG_NO ,BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD," ).append("\n"); 
		query.append("	NVL(BKG.BL_NO||BKG.BL_TP_CD,' ') , " ).append("\n"); 
		query.append("	NVL(BKG.RCV_TERM_CD, ' ')," ).append("\n"); 
		query.append("	NVL(BKG.DE_TERM_CD, ' ')," ).append("\n"); 
		query.append("	DECODE(BV.POL_CD, 'MXESE', DECODE(BKG.POL_CD, 'MXESE', 'L', 'T')," ).append("\n"); 
		query.append("	DECODE(BV.POD_CD, 'MXESE', DECODE(BKG.POD_CD, 'MXESE', 'L', 'T'), ' ')) ," ).append("\n"); 
		query.append("	BKG.POR_CD, BV.POL_CD , BV.POD_CD , BKG.DEL_CD, BKG.STWG_CD," ).append("\n"); 
		query.append("	DOC.ACT_WGT, DOC.WGT_UT_CD," ).append("\n"); 
		query.append("	DOC.PCK_QTY," ).append("\n"); 
		query.append("	NVL(BR.FRT_TERM_CD, ' ') ," ).append("\n"); 
		query.append("	DECODE(BKG.HOT_DE_FLG, 'Y', 'H', ' ') ," ).append("\n"); 
		query.append("	DECODE(BKG.RC_FLG, 'Y', 'R', ' ') ," ).append("\n"); 
		query.append("	CD.INTG_CD_VAL_DP_DESC, BKG.BL_NO" ).append("\n"); 
		query.append("ORDER BY BKG.BL_NO" ).append("\n"); 

	}
}