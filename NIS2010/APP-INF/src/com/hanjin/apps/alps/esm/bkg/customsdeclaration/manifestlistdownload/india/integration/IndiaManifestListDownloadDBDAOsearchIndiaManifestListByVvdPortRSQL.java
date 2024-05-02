/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOsearchIndiaManifestListByVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOsearchIndiaManifestListByVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신고대상을 조회해 온다.- H/BL도 대상임
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOsearchIndiaManifestListByVvdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("entry_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOsearchIndiaManifestListByVvdPortRSQL").append("\n"); 
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
		query.append("        '' 						IGM_NO 	/* 상위 배정보 VO 생성을 위해 */" ).append("\n"); 
		query.append("        ,''						IGM_DATE/* 상위 배정보 VO 생성을 위해 */" ).append("\n"); 
		query.append("        ,''						VSL_NM 	/* 상위 배정보 VO 생성을 위해 */" ).append("\n"); 
		query.append("        ,''						ETA_DT 	/* 상위 배정보 VO 생성을 위해 */" ).append("\n"); 
		query.append("        ,BL_NO" ).append("\n"); 
		query.append("        ,MERGE_BL_NO" ).append("\n"); 
		query.append("        ,SUM(C_BL_NO) OVER (ORDER BY ENTRY_TP, DEL_CD, POL_CD, BL_NO, HBL_NO, HBL_IND) GROUP_SEQ " ).append("\n"); 
		query.append("        ,HBL_NO" ).append("\n"); 
		query.append("        ,POL_CD" ).append("\n"); 
		query.append("        ,POD_CD" ).append("\n"); 
		query.append("        ,POD_NOD_CD" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("        ,DEL_NOD_CD" ).append("\n"); 
		query.append("        ,ENTRY_TP" ).append("\n"); 
		query.append("        ,DEST_CD" ).append("\n"); 
		query.append("        ,CFS_CD" ).append("\n"); 
		query.append("        ,IAL" ).append("\n"); 
		query.append("        ,MODE_TRANS" ).append("\n"); 
		query.append("        ,CUSTOMER_NAME" ).append("\n"); 
		query.append("        ,BL_CUST_TP" ).append("\n"); 
		query.append("        ,HBL_IND" ).append("\n"); 
		query.append("        ,BCD_DESC" ).append("\n"); 
		query.append("        ,ITEM_TP" ).append("\n"); 
		query.append("        ,BD_AREA_CD" ).append("\n"); 
		query.append("        ,TRNS_OPR_ID" ).append("\n"); 
		query.append("        ,IDA_LINE_NO" ).append("\n"); 
		query.append("        ,VVD_CD" ).append("\n"); 
		query.append("        ,DOWN_CHECK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	    SUB1.BL_NO              BL_NO" ).append("\n"); 
		query.append("	    ,SUB1.BL_NO             MERGE_BL_NO" ).append("\n"); 
		query.append("	    ,SUB1.HBL_NO        	HBL_NO" ).append("\n"); 
		query.append("	    ,SUB1.POL_CD        	POL_CD" ).append("\n"); 
		query.append("	    ,SUB1.POD_CD        	POD_CD" ).append("\n"); 
		query.append("		,SUBSTR(SUB1.POD_NOD_CD, 6, 2)        POD_NOD_CD" ).append("\n"); 
		query.append("	    ,SUB1.DEL_CD        	DEL_CD" ).append("\n"); 
		query.append("		,SUBSTR(SUB1.DEL_NOD_CD, 6, 2)        DEL_NOD_CD" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.ENTRY_TP,''), BCIB.BL_DECL_TP_CD) ENTRY_TP" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.DEST_CD,''), BCIB.IDA_DEST_CD) DEST_CD" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.CFS_CD,''), BCIB.IDA_CFS_ID) CFS_CD" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.IAL,''), BCIB.IAL_RGN_CD) IAL" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.MODE_TRANS,''), BCIB.IDA_TRSP_CD) MODE_TRANS" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.CUSTOMER_NAME,''), BCIB.CNEE_NM) CUSTOMER_NAME" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', NVL(SUB1.BL_CUST_TP,''), BCIB.IDA_CSTMS_BL_TP_CD)   	BL_CUST_TP" ).append("\n"); 
		query.append("	    ,SUB1.HBL_IND       	HBL_IND" ).append("\n"); 
		query.append("	    ,SUB1.BCD_DESC   	    BCD_DESC" ).append("\n"); 
		query.append("	    ,DECODE(DECODE(NVL(BCIB.NVOCC_REF_NO, ''), '', NVL(SUB1.ITEM_TP, ''), BCIB.IDA_CSTMS_ITM_TP_CD), '', 'O', BCIB.IDA_CSTMS_ITM_TP_CD)  ITEM_TP" ).append("\n"); 
		query.append("		,DECODE(NVL(BCIB.NVOCC_REF_NO, ''), '',SUB1.CFS_BOND_CD, BCIB.BD_AREA_CD)   	BD_AREA_CD" ).append("\n"); 
		query.append("	    ,DECODE(NVL(BCIB.NVOCC_REF_NO,''), '', SUB1.TRNS_OPR_ID, BCIB.TRNS_OPR_ID)    	TRNS_OPR_ID" ).append("\n"); 
		query.append("	    ,BCIB.IDA_LINE_NO       IDA_LINE_NO" ).append("\n"); 
		query.append("		,@[vvd_cd]	VVD_CD	" ).append("\n"); 
		query.append("		,DECODE(BCIB.VSL_CD||BCIB.SKD_VOY_NO||BCIB.SKD_DIR_CD||BCIB.POD_CD||BCIB.BL_NO||BCIB.NVOCC_REF_NO, '', 'N', 'Y') DOWN_CHECK" ).append("\n"); 
		query.append("		,DECODE(LAG(SUB1.BL_NO) OVER ( ORDER BY SUB1.ENTRY_TP, SUB1.DEL_CD, SUB1.POL_CD, SUB1.BL_NO, SUB1.HBL_NO, SUB1.HBL_IND) , SUB1.BL_NO, 0, 1) C_BL_NO" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	    (" ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	            DISTINCT BB.BL_NO BL_NO" ).append("\n"); 
		query.append("	            ,DECODE(BH.HBL_NO, '', BB.BL_NO, BH.HBL_NO) HBL_NO" ).append("\n"); 
		query.append("	            ,BB.POL_CD                             POL_CD" ).append("\n"); 
		query.append("                ,BB.POD_CD                             POD_CD" ).append("\n"); 
		query.append("                ,BB.POD_NOD_CD                         POD_NOD_CD              " ).append("\n"); 
		query.append("                ,BB.DEL_CD                             DEL_CD" ).append("\n"); 
		query.append("                ,BB.DEL_NOD_CD                         DEL_NOD_CD" ).append("\n"); 
		query.append("	            ,'LC'                                  ENTRY_TP" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                    SELECT DECODE(COUNT(OTR_DCHG_CD), 1, MIN(OTR_DCHG_CD), BCIV.OTR_DCHG_YD_ID)" ).append("\n"); 
		query.append("                    FROM BKG_DCHG_LOC" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND NVL(LOC_CD , ' ') LIKE 'IN' || '%'" ).append("\n"); 
		query.append("                    AND LOC_CD = BB.DEL_CD" ).append("\n"); 
		query.append("					AND YD_CD = BB.DEL_NOD_CD" ).append("\n"); 
		query.append("                 ) DEST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    		,BCIV.IDA_CFS_ID                       CFS_CD" ).append("\n"); 
		query.append("	    		,''                                    IAL" ).append("\n"); 
		query.append("	    		,''                                    MODE_TRANS" ).append("\n"); 
		query.append("	    		,REPLACE(REPLACE(BC.CUST_NM, CHR(13)|| CHR(10), ''),CHR(9),' ') CUSTOMER_NAME" ).append("\n"); 
		query.append("	    		,BB.KR_CSTMS_CUST_TP_CD                BL_CUST_TP" ).append("\n"); 
		query.append("	    		,DECODE(BH.HBL_NO, '', '00', BH.HBL_SEQ)   HBL_IND" ).append("\n"); 
		query.append("	    		,REPLACE(REPLACE(   REPLACE(DECODE(BH.HBL_NO, '', SUBSTR(BBD.CSTMS_DESC, 1, 44), SUBSTR(BH.BL_GDS_DESC, 1, 44)), CHR(13), ''), CHR(10), ''),CHR(9),' ') BCD_DESC" ).append("\n"); 
		query.append("	    		,''                                 ITEM_TP" ).append("\n"); 
		query.append("				,''									CFS_BOND_CD" ).append("\n"); 
		query.append("	    		,''				                    TRNS_OPR_ID" ).append("\n"); 
		query.append("	    		,BCIV.VSL_CD                        VSL_CD" ).append("\n"); 
		query.append("	    		,BCIV.SKD_VOY_NO                    SKD_VOY_NO" ).append("\n"); 
		query.append("	    		,BCIV.SKD_DIR_CD                    SKD_DIR_CD" ).append("\n"); 
		query.append("	    FROM    BKG_BOOKING BB" ).append("\n"); 
		query.append("	            ,MDM_CUSTOMER MC" ).append("\n"); 
		query.append("	            ,BKG_CUSTOMER BC    " ).append("\n"); 
		query.append("	            ,BKG_BL_DOC BBD" ).append("\n"); 
		query.append("	            ,BKG_BL_MK_DESC BBMD" ).append("\n"); 
		query.append("	            ,BKG_HBL BH" ).append("\n"); 
		query.append("	            ,BKG_CSTMS_IDA_VSL BCIV" ).append("\n"); 
		query.append("	            ,(SELECT	BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("	    					,BKG_VVD.VSL_CD" ).append("\n"); 
		query.append("	        		FROM	BKG_VVD" ).append("\n"); 
		query.append("	        		WHERE	BKG_VVD.VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("				) BV" ).append("\n"); 
		query.append("	    WHERE	BB.POD_CD                 = @[pod_cd]" ).append("\n"); 
		query.append("		#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("	    AND     BB.BKG_CGO_TP_CD         <>  'P'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    AND	    BB.BKG_STS_CD		      <> 'X'" ).append("\n"); 
		query.append("	    AND	    BB.POD_CD		        = BB.DEL_CD" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO		        = BV.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO		        = BBD.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO               = BBMD.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO               = BH.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND	    BC.BKG_NO		        = BB.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BC.BKG_CUST_TP_CD       = 'C'" ).append("\n"); 
		query.append("	    AND	    MC.CUST_CNT_CD(+)       = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("	    AND	    MC.CUST_SEQ(+)          = BC.CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    AND	    BCIV.VSL_CD             = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	    AND	    BCIV.SKD_VOY_NO         = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	    AND	    BCIV.SKD_DIR_CD         = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	    AND	    BCIV.POD_CD             = @[pod_cd]" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	    AND	    BB.POL_CD               LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	    AND     ( 1 <= (   SELECT COUNT(HBL_NO)" ).append("\n"); 
		query.append("	                    FROM BKG_HBL A" ).append("\n"); 
		query.append("	                    WHERE BB.BKG_NO = A.BKG_NO )  OR" ).append("\n"); 
		query.append("	            0 = (   SELECT COUNT(HBL_NO)" ).append("\n"); 
		query.append("	                    FROM BKG_HBL A" ).append("\n"); 
		query.append("	                    WHERE BB.BKG_NO = A.BKG_NO) )" ).append("\n"); 
		query.append("	                    " ).append("\n"); 
		query.append("	    UNION ALL" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	            DISTINCT BB.BL_NO BL_NO" ).append("\n"); 
		query.append("	            ,DECODE(BH.HBL_NO, '', BB.BL_NO, BH.HBL_NO) HBL_NO" ).append("\n"); 
		query.append("	            ,BB.POL_CD                             POL_CD" ).append("\n"); 
		query.append("                ,BB.POD_CD                             POD_CD" ).append("\n"); 
		query.append("                ,BB.POD_NOD_CD                         POD_NOD_CD              " ).append("\n"); 
		query.append("                ,BB.DEL_CD                             DEL_CD" ).append("\n"); 
		query.append("                ,BB.DEL_NOD_CD                         DEL_NOD_CD" ).append("\n"); 
		query.append("	            ,'TI'                                  ENTRY_TP" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                    SELECT DECODE(COUNT(OTR_DCHG_CD), 1, MIN(OTR_DCHG_CD), BCIV.OTR_DCHG_YD_ID)" ).append("\n"); 
		query.append("                    FROM BKG_DCHG_LOC" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND NVL(LOC_CD , ' ') LIKE 'IN' || '%'" ).append("\n"); 
		query.append("                    AND LOC_CD = BB.DEL_CD" ).append("\n"); 
		query.append("					AND YD_CD = BB.DEL_NOD_CD" ).append("\n"); 
		query.append("                 ) DEST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				,''                                    CFS_CD" ).append("\n"); 
		query.append("	    		,''                                    IAL" ).append("\n"); 
		query.append("	    		,'T'                                    MODE_TRANS" ).append("\n"); 
		query.append("	    		,REPLACE(REPLACE(BC.CUST_NM, CHR(13)|| CHR(10), ''),CHR(9),' ') CUSTOMER_NAME" ).append("\n"); 
		query.append("	    		,BB.KR_CSTMS_CUST_TP_CD                BL_CUST_TP" ).append("\n"); 
		query.append("	    		,DECODE(BH.HBL_NO, '', '00', BH.HBL_SEQ)   HBL_IND" ).append("\n"); 
		query.append("	    		,REPLACE(REPLACE(   REPLACE(DECODE(BH.HBL_NO, '', SUBSTR(BBD.CSTMS_DESC, 1, 44), SUBSTR(BH.BL_GDS_DESC, 1, 44)), CHR(13), ''), CHR(10), ''),CHR(9),' ') BCD_DESC" ).append("\n"); 
		query.append("	    		,''                                 ITEM_TP" ).append("\n"); 
		query.append("				  ,''																	CFS_BOND_CD" ).append("\n"); 
		query.append("	    		,BCIV.TRNS_OPR_ID                   TRNS_OPR_ID" ).append("\n"); 
		query.append("	    		,BCIV.VSL_CD                        VSL_CD" ).append("\n"); 
		query.append("	    		,BCIV.SKD_VOY_NO                    SKD_VOY_NO" ).append("\n"); 
		query.append("	    		,BCIV.SKD_DIR_CD                    SKD_DIR_CD" ).append("\n"); 
		query.append("	    FROM    BKG_BOOKING BB" ).append("\n"); 
		query.append("	            ,MDM_CUSTOMER MC" ).append("\n"); 
		query.append("	            ,BKG_CUSTOMER BC    " ).append("\n"); 
		query.append("	            ,BKG_BL_DOC BBD" ).append("\n"); 
		query.append("	            ,BKG_BL_MK_DESC BBMD" ).append("\n"); 
		query.append("	            ,BKG_HBL BH" ).append("\n"); 
		query.append("	            ,BKG_CSTMS_IDA_VSL BCIV" ).append("\n"); 
		query.append("	            ,BKG_DCHG_LOC BDL" ).append("\n"); 
		query.append("	            ,(SELECT	BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("	    					,BKG_VVD.VSL_CD" ).append("\n"); 
		query.append("	        		FROM	BKG_VVD" ).append("\n"); 
		query.append("	        		WHERE	BKG_VVD.VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("				) BV" ).append("\n"); 
		query.append("	    WHERE	BB.POD_CD                 = @[pod_cd]" ).append("\n"); 
		query.append("		#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("	    AND     BB.BKG_CGO_TP_CD          <> 'P'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    AND	    BB.BKG_STS_CD		      <> 'X'" ).append("\n"); 
		query.append("	    AND	    BB.POD_CD		        <> BB.DEL_CD" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO		        = BV.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO		        = BBD.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO               = BBMD.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO               = BH.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND	    BC.BKG_NO		        = BB.BKG_NO" ).append("\n"); 
		query.append("	    AND     BB.DEL_CD               = BDL.OTR_DCHG_CD(+)" ).append("\n"); 
		query.append("	    AND     BB.DEL_CD||BB.DEL_NOD_CD = BDL.YD_CD(+)" ).append("\n"); 
		query.append("	    AND	    BC.BKG_CUST_TP_CD       = 'C'" ).append("\n"); 
		query.append("	    AND	    MC.CUST_CNT_CD(+)       = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("	    AND	    MC.CUST_SEQ(+)          = BC.CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    AND	    BCIV.VSL_CD             = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	    AND	    BCIV.SKD_VOY_NO         = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	    AND	    BCIV.SKD_DIR_CD         = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	    AND	    BCIV.POD_CD             = @[pod_cd]" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	    AND	    BB.POL_CD               LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	    AND     ( 1 <= (   SELECT COUNT(HBL_NO)" ).append("\n"); 
		query.append("	                    FROM BKG_HBL A" ).append("\n"); 
		query.append("	                    WHERE BB.BKG_NO = A.BKG_NO )  OR" ).append("\n"); 
		query.append("	            0 = (   SELECT COUNT(HBL_NO)" ).append("\n"); 
		query.append("	                    FROM BKG_HBL A" ).append("\n"); 
		query.append("	                    WHERE BB.BKG_NO = A.BKG_NO ) )" ).append("\n"); 
		query.append("	                    " ).append("\n"); 
		query.append("	    UNION ALL" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	            DISTINCT BB.BL_NO BL_NO" ).append("\n"); 
		query.append("	            ,DECODE(BH.HBL_NO, '', BB.BL_NO, BH.HBL_NO) HBL_NO" ).append("\n"); 
		query.append("	            ,BB.POL_CD                             POL_CD" ).append("\n"); 
		query.append("                ,BB.POD_CD                             POD_CD" ).append("\n"); 
		query.append("                ,BB.POD_NOD_CD                         POD_NOD_CD              " ).append("\n"); 
		query.append("                ,BB.DEL_CD                             DEL_CD" ).append("\n"); 
		query.append("                ,BB.DEL_NOD_CD                         DEL_NOD_CD" ).append("\n"); 
		query.append("	            ,'TC'                                  ENTRY_TP" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                    SELECT DECODE(COUNT(OTR_DCHG_CD), 1, MIN(OTR_DCHG_CD), BCIV.OTR_DCHG_YD_ID)" ).append("\n"); 
		query.append("                    FROM BKG_DCHG_LOC" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND NVL(LOC_CD , ' ') LIKE 'IN' || '%'" ).append("\n"); 
		query.append("                    AND LOC_CD = BB.DEL_CD" ).append("\n"); 
		query.append("					AND YD_CD = BB.DEL_NOD_CD" ).append("\n"); 
		query.append("                 ) DEST_CD" ).append("\n"); 
		query.append("	    		" ).append("\n"); 
		query.append("				,''                                    CFS_CD" ).append("\n"); 
		query.append("	    		,''                                    IAL" ).append("\n"); 
		query.append("	    		,''                                    MODE_TRANS" ).append("\n"); 
		query.append("	    		,REPLACE(REPLACE(BC.CUST_NM, CHR(13)|| CHR(10), ''),CHR(9),' ') CUSTOMER_NAME" ).append("\n"); 
		query.append("	    		,BB.KR_CSTMS_CUST_TP_CD                BL_CUST_TP" ).append("\n"); 
		query.append("	    		,DECODE(BH.HBL_NO, '', '00', BH.HBL_SEQ)   HBL_IND" ).append("\n"); 
		query.append("	    		,REPLACE(REPLACE(   REPLACE(DECODE(BH.HBL_NO, '', SUBSTR(BBD.CSTMS_DESC, 1, 44), SUBSTR(BH.BL_GDS_DESC, 1, 44)), CHR(13), ''), CHR(10), ''),CHR(9),' ') BCD_DESC" ).append("\n"); 
		query.append("	    		,''                                 ITEM_TP" ).append("\n"); 
		query.append("				  ,''																	CFS_BOND_CD" ).append("\n"); 
		query.append("	    		,BCIV.TRNS_OPR_ID                   TRNS_OPR_ID" ).append("\n"); 
		query.append("	    		,BCIV.VSL_CD                        VSL_CD" ).append("\n"); 
		query.append("	    		,BCIV.SKD_VOY_NO                    SKD_VOY_NO" ).append("\n"); 
		query.append("	    		,BCIV.SKD_DIR_CD                    SKD_DIR_CD" ).append("\n"); 
		query.append("	    FROM    BKG_BOOKING BB" ).append("\n"); 
		query.append("	            ,MDM_CUSTOMER MC" ).append("\n"); 
		query.append("	            ,BKG_CUSTOMER BC    " ).append("\n"); 
		query.append("	            ,BKG_BL_DOC BBD" ).append("\n"); 
		query.append("	            ,BKG_BL_MK_DESC BBMD" ).append("\n"); 
		query.append("	            ,BKG_HBL BH" ).append("\n"); 
		query.append("	            ,BKG_CSTMS_IDA_VSL BCIV" ).append("\n"); 
		query.append("	            ,(SELECT	BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("	    					,BKG_VVD.VSL_CD" ).append("\n"); 
		query.append("	        		FROM	BKG_VVD" ).append("\n"); 
		query.append("	        		WHERE	BKG_VVD.VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	        		AND	BKG_VVD.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("				) BV" ).append("\n"); 
		query.append("	            ,(  " ).append("\n"); 
		query.append("	                SELECT  A.BKG_NO" ).append("\n"); 
		query.append("	                FROM" ).append("\n"); 
		query.append("	                   (" ).append("\n"); 
		query.append("	                      SELECT   BKG_BOOKING.BKG_NO" ).append("\n"); 
		query.append("	                      FROM     BKG_BOOKING" ).append("\n"); 
		query.append("	                               ,BKG_VVD" ).append("\n"); 
		query.append("	                               ,(" ).append("\n"); 
		query.append("	                               SELECT  BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("	                                       ,BKG_VVD.POL_CD" ).append("\n"); 
		query.append("	                                       ,BKG_VVD.POD_CD" ).append("\n"); 
		query.append("	                               FROM    BKG_VVD" ).append("\n"); 
		query.append("	                               WHERE   BKG_VVD.VSL_CD          	= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	                                AND    BKG_VVD.SKD_VOY_NO       = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	                                AND    BKG_VVD.SKD_DIR_CD       = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	                                AND    BKG_VVD.POL_CD         IN (  	SELECT VPS_PORT_CD FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	                                                                        WHERE  VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	                                                                        AND    SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	                                                                        AND    SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	                                                                        AND    CLPT_SEQ     <   (" ).append("\n"); 
		query.append("	                                                                                                     SELECT  MAX(CLPT_SEQ)    FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	                                                                                                     WHERE   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	                                                                                                     AND    SKD_VOY_NO     = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	                                                                                                     AND    SKD_DIR_CD     = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	                                                                                                     AND     VPS_PORT_CD    = @[pod_cd]" ).append("\n"); 
		query.append("	                                                                                                     ) )" ).append("\n"); 
		query.append("	                                )    BKG_VVD2" ).append("\n"); 
		query.append("	                      WHERE   BKG_BOOKING.BKG_NO        =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("	                      AND     BKG_BOOKING.POD_CD        <>   @[pod_cd]" ).append("\n"); 
		query.append("	                      AND     BKG_VVD.BKG_NO            =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("	                      AND     BKG_VVD.POL_CD            =   @[pod_cd]" ).append("\n"); 
		query.append("	                   )        A" ).append("\n"); 
		query.append("	                   ,(" ).append("\n"); 
		query.append("	                      SELECT   BKG_BOOKING.BKG_NO" ).append("\n"); 
		query.append("	                      FROM     BKG_BOOKING" ).append("\n"); 
		query.append("	                               ,BKG_VVD" ).append("\n"); 
		query.append("	                               ,(" ).append("\n"); 
		query.append("	                               SELECT  BKG_VVD.BKG_NO" ).append("\n"); 
		query.append("	                                       ,BKG_VVD.POL_CD" ).append("\n"); 
		query.append("	                                       ,BKG_VVD.POD_CD" ).append("\n"); 
		query.append("	                               FROM    BKG_VVD" ).append("\n"); 
		query.append("	                               WHERE   BKG_VVD.VSL_CD         = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	                                AND    BKG_VVD.SKD_VOY_NO     = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	                                AND    BKG_VVD.SKD_DIR_CD     = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	                                )    BKG_VVD2" ).append("\n"); 
		query.append("	                      WHERE   BKG_BOOKING.BKG_NO        =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("	                      AND     BKG_BOOKING.POD_CD        <>   @[pod_cd]" ).append("\n"); 
		query.append("	                      AND     BKG_VVD.BKG_NO            =   BKG_VVD2.BKG_NO" ).append("\n"); 
		query.append("	                      AND     BKG_VVD.POD_CD            =   @[pod_cd]" ).append("\n"); 
		query.append("	                   )        B" ).append("\n"); 
		query.append("	                   WHERE   A.BKG_NO         =   B.BKG_NO" ).append("\n"); 
		query.append("	            ) TS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    WHERE	1=1" ).append("\n"); 
		query.append("		#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("		AND 	BB.BKG_CGO_TP_CD          <> 'P'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    AND	    BB.BKG_STS_CD		      <> 'X'" ).append("\n"); 
		query.append("	    AND	    BB.POD_CD		        = BB.DEL_CD" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO		        = BV.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO		        = BBD.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO               = BBMD.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND	    BB.BKG_NO               = BH.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND	    BC.BKG_NO		        = BB.BKG_NO" ).append("\n"); 
		query.append("	    AND	    BC.BKG_CUST_TP_CD       = 'C'" ).append("\n"); 
		query.append("	    AND	    MC.CUST_CNT_CD(+)       = BC.CUST_CNT_CD" ).append("\n"); 
		query.append("	    AND	    MC.CUST_SEQ(+)          = BC.CUST_SEQ" ).append("\n"); 
		query.append("	    AND		BB.BKG_NO				= TS.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    AND	    BCIV.VSL_CD             = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	    AND	    BCIV.SKD_VOY_NO         = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	    AND	    BCIV.SKD_DIR_CD         = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	    AND	    BCIV.POD_CD             = @[pod_cd]" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	    AND	    BB.POL_CD               LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	    AND     ( 1 <= (   SELECT COUNT(HBL_NO)" ).append("\n"); 
		query.append("	                    FROM BKG_HBL A" ).append("\n"); 
		query.append("	                    WHERE BB.BKG_NO = A.BKG_NO )  OR" ).append("\n"); 
		query.append("	            0 = (   SELECT COUNT(HBL_NO)" ).append("\n"); 
		query.append("	                    FROM BKG_HBL A" ).append("\n"); 
		query.append("	                    WHERE BB.BKG_NO = A.BKG_NO )  AND  BH.HBL_SEQ = '01' )" ).append("\n"); 
		query.append("	    ) SUB1" ).append("\n"); 
		query.append("	    , BKG_CSTMS_IDA_BL BCIB" ).append("\n"); 
		query.append("	WHERE SUB1.VSL_CD       =  BCIB.VSL_CD(+)" ).append("\n"); 
		query.append("	AND   SUB1.SKD_VOY_NO   =  BCIB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	AND   SUB1.SKD_DIR_CD   =  BCIB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	AND   SUB1.POD_CD       =  BCIB.POD_CD(+)" ).append("\n"); 
		query.append("	AND   SUB1.BL_NO        =  BCIB.BL_NO(+)" ).append("\n"); 
		query.append("	AND   SUB1.HBL_NO       = BCIB.NVOCC_REF_NO(+)" ).append("\n"); 
		query.append("	AND   BCIB.VSL_CD(+)       = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	AND   BCIB.SKD_VOY_NO(+)   = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	AND   BCIB.SKD_DIR_CD(+)   = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	AND   BCIB.POD_CD(+)       = @[pod_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${entry_type} != '0' && ${entry_type} != '')" ).append("\n"); 
		query.append("AND ENTRY_TP = DECODE(@[entry_type], '1', 'LC'" ).append("\n"); 
		query.append("								   , '2', 'TI'" ).append("\n"); 
		query.append("								   , '3', 'TC' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ENTRY_TP, DEL_CD, POL_CD, BL_NO, HBL_NO, HBL_IND" ).append("\n"); 

	}
}