/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOSearchBkgListForVslSkdCngNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.03 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOSearchBkgListForVslSkdCngNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 변경된 VVD,POL로 기존에 생성되어 있는 Booking을 조회한다.
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOSearchBkgListForVslSkdCngNoticeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOSearchBkgListForVslSkdCngNoticeRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_CLOB_FNC(CURSOR(SELECT CASE WHEN LENGTH(BK.BKG_NO)=11 then BK.BKG_NO||'  '" ).append("\n"); 
		query.append("                             		   WHEN LENGTH(BK.BKG_NO)=12 then BK.BKG_NO||' '" ).append("\n"); 
		query.append("                            		   ELSE BK.BKG_NO end BKG_NO" ).append("\n"); 
		query.append("    						  FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("						     WHERE BK.BKG_NO		= VVD.BKG_NO" ).append("\n"); 
		query.append("							   AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("							   AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("    						   AND BK.BKG_OFC_CD  	= LIST.BKG_OFC_CD" ).append("\n"); 
		query.append("    						   AND VVD.VSL_CD     	= LIST.VSL_CD" ).append("\n"); 
		query.append("    						   AND VVD.SKD_VOY_NO 	= LIST.SKD_VOY_NO" ).append("\n"); 
		query.append("    						   AND VVD.SKD_DIR_CD 	= LIST.SKD_DIR_CD" ).append("\n"); 
		query.append("    						   AND LIST.PORT_CD     = DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CD,           VVD.POD_CD)    						 " ).append("\n"); 
		query.append("    						   AND LIST.YD_CD       = DECODE(LIST.CNG_PORT, 'POL', VVD.POL_YD_CD,        VVD.POD_YD_CD)" ).append("\n"); 
		query.append("    						   AND LIST.CLPT_IND_SEQ= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CLPT_IND_SEQ, VVD.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("    						 )) BKG_NO_LIST" ).append("\n"); 
		query.append("        , LIST.VSL_CD||LIST.SKD_VOY_NO||LIST.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        , LIST.PORT_CD" ).append("\n"); 
		query.append("        , LIST.YD_CD" ).append("\n"); 
		query.append("        , @[type_cd] TYPE_CD" ).append("\n"); 
		query.append("		, @[remark]  REMARK" ).append("\n"); 
		query.append("     	, LIST.BKG_OFC_CD" ).append("\n"); 
		query.append(", REPLACE(BKG_JOIN_CLOB_FNC(CURSOR( SELECT DISTINCT USR.USR_EML" ).append("\n"); 
		query.append("                                 FROM COM_USER USR, BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("								WHERE BK.BKG_NO			= VVD.BKG_NO" ).append("\n"); 
		query.append("							      AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("							      AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                                  AND BK.BKG_OFC_CD 	= LIST.BKG_OFC_CD" ).append("\n"); 
		query.append("                                  AND VVD.VSL_CD 		= LIST.VSL_CD" ).append("\n"); 
		query.append("                                  AND VVD.SKD_VOY_NO 	= LIST.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND VVD.SKD_DIR_CD 	= LIST.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND LIST.PORT_CD 		= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CD, 			VVD.POD_CD)" ).append("\n"); 
		query.append("                                  AND LIST.YD_CD 		= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_YD_CD,		VVD.POD_YD_CD)" ).append("\n"); 
		query.append("                                  AND LIST.CLPT_IND_SEQ = DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CLPT_IND_SEQ,VVD.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                  AND USR.USE_FLG		= 'Y'" ).append("\n"); 
		query.append("                                  AND USR.USR_ID 		= BK.DOC_USR_ID" ).append("\n"); 
		query.append("                                  and USR.USR_EML 		IS NOT NULL" ).append("\n"); 
		query.append("                                  and USR.USR_EML 		LIKE '%@%')), ',', ';') RCV_EML_LIST " ).append("\n"); 
		query.append(", BKG_JOIN_CLOB_FNC(CURSOR(         SELECT DISTINCT USR.USR_NM" ).append("\n"); 
		query.append("                                 FROM COM_USER USR, BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("								WHERE BK.BKG_NO			= VVD.BKG_NO" ).append("\n"); 
		query.append("							      AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("							      AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                                  AND BK.BKG_OFC_CD 	= LIST.BKG_OFC_CD" ).append("\n"); 
		query.append("                                  AND VVD.VSL_CD 		= LIST.VSL_CD" ).append("\n"); 
		query.append("                                  AND VVD.SKD_VOY_NO 	= LIST.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND VVD.SKD_DIR_CD 	= LIST.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND LIST.PORT_CD 		= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CD, 			VVD.POD_CD)" ).append("\n"); 
		query.append("                                  AND LIST.YD_CD 		= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_YD_CD, 		VVD.POD_YD_CD)" ).append("\n"); 
		query.append("                                  AND LIST.CLPT_IND_SEQ = DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CLPT_IND_SEQ,VVD.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                  AND USR.USE_FLG 		= 'Y'" ).append("\n"); 
		query.append("                                  AND USR.USR_ID 		= BK.DOC_USR_ID" ).append("\n"); 
		query.append("                                  and USR.USR_EML 		IS NOT NULL" ).append("\n"); 
		query.append("                                  and USR.USR_EML 		LIKE '%@%')) RCV_USR_NM " ).append("\n"); 
		query.append(", BKG_JOIN_CLOB_FNC(CURSOR(         SELECT DISTINCT USR.USR_ID" ).append("\n"); 
		query.append("                                 FROM COM_USER USR, BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("								WHERE BK.BKG_NO			= VVD.BKG_NO" ).append("\n"); 
		query.append("							      AND BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("							      AND BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("                                  AND BK.BKG_OFC_CD 	= LIST.BKG_OFC_CD" ).append("\n"); 
		query.append("                                  AND VVD.VSL_CD 		= LIST.VSL_CD" ).append("\n"); 
		query.append("                                  AND VVD.SKD_VOY_NO 	= LIST.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND VVD.SKD_DIR_CD 	= LIST.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND LIST.PORT_CD 		= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CD, 			VVD.POD_CD)" ).append("\n"); 
		query.append("                                  AND LIST.YD_CD 		= DECODE(LIST.CNG_PORT, 'POL', VVD.POL_YD_CD, 		VVD.POD_YD_CD)" ).append("\n"); 
		query.append("                                  AND LIST.CLPT_IND_SEQ = DECODE(LIST.CNG_PORT, 'POL', VVD.POL_CLPT_IND_SEQ,VVD.POD_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("                                  AND USR.USE_FLG		= 'Y'" ).append("\n"); 
		query.append("                                  AND USR.USR_ID 		= BK.DOC_USR_ID" ).append("\n"); 
		query.append("                                  and USR.USR_EML 		IS NOT NULL" ).append("\n"); 
		query.append("                                  and USR.USR_EML 		LIKE '%@%')) RCV_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT DISTINCT VVD.VSL_CD" ).append("\n"); 
		query.append("                , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("         		, VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("         		, DECODE(@[port_cd], VVD.POL_CD, 'POL',                'POD')                CNG_PORT" ).append("\n"); 
		query.append("         		, DECODE(@[port_cd], VVD.POL_CD, VVD.POL_CD,           VVD.POD_CD)           PORT_CD" ).append("\n"); 
		query.append("         		, DECODE(@[port_cd], VVD.POL_CD, VVD.POL_YD_CD,        VVD.POD_YD_CD)        YD_CD" ).append("\n"); 
		query.append("         		, DECODE(@[port_cd], VVD.POL_CD, VVD.POL_CLPT_IND_SEQ, VVD.POD_CLPT_IND_SEQ) CLPT_IND_SEQ" ).append("\n"); 
		query.append("         		, BK.BKG_OFC_CD         		" ).append("\n"); 
		query.append("        FROM	BKG_BOOKING BK," ).append("\n"); 
		query.append("        		BKG_VVD VVD" ).append("\n"); 
		query.append("        WHERE	BK.BKG_STS_CD    <> 'X'" ).append("\n"); 
		query.append("		  AND   BK.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("          AND 	BK.BKG_NO        = VVD.BKG_NO" ).append("\n"); 
		query.append("          AND 	VVD.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("          AND 	VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND 	VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if(${port_cd} != '' && ${clpt_ind_seq} != '' )" ).append("\n"); 
		query.append("          AND 	((VVD.POL_CD = @[port_cd] AND nvl(VVD.POL_CLPT_IND_SEQ, 1) = @[clpt_ind_seq])" ).append("\n"); 
		query.append("				--phase out일 때 pod로 bkg을 찾지 않음" ).append("\n"); 
		query.append("        	  OR (@[type_cd] <> 'O' AND VVD.POD_CD = @[port_cd] AND nvl(VVD.POD_CLPT_IND_SEQ, 1) = @[clpt_ind_seq]))        	" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("         ORDER BY BK.BKG_OFC_CD) LIST" ).append("\n"); 

	}
}