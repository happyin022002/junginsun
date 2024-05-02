/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchManifestDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchManifestDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaBlInfoDetailListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchManifestDetailListRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchManifestDetailListRSQL").append("\n"); 
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
		query.append("SELECT	'' AS SVC_PVD           /*SERVICE_PROVIDER*/" ).append("\n"); 
		query.append("       ,'SMLM'||BL.BL_NO AS BL  /*BL*/ " ).append("\n"); 
		query.append("       ,POR.LOC_NM AS POR       /*POR*/    " ).append("\n"); 
		query.append("       ,POL.LOC_NM AS POL       /*POL*/    " ).append("\n"); 
		query.append("       ,POD.LOC_NM AS POD       /*POD*/    " ).append("\n"); 
		query.append("       ,DEL.LOC_NM AS DEL       /*DEL*/    " ).append("\n"); 
		query.append("       ,BL.ACT_WGT AS WGT       /*TTL_WEIGHT*/ " ).append("\n"); 
		query.append("       ,BL.PCK_QTY AS PCK       /*TTL_PACKAGE*/" ).append("\n"); 
		query.append("       ,BL.MEAS_QTY AS MEAS     /*Measurement*/" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(S.CUST_ADDR,CHR(13)||CHR(10),' '),CHR(9),' ') AS SHPR  /*Shipper*/	" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(C.CUST_ADDR,CHR(13)||CHR(10),' '),CHR(9),' ') AS CNEE  /*Consignee*/	" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(N.CUST_ADDR,CHR(13)||CHR(10),' '),CHR(9),' ') AS NTFY  /*Notify*/" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(REPLACE(MARK.MK_DESC, CHR(34), CHR(34)||CHR(34)),CHR(13)||CHR(10),' '),CHR(9),' ') AS MK_DESC" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(REPLACE(MARK.CMDT_DESC, CHR(34), CHR(34)||CHR(34)),CHR(13)||CHR(10),' '),CHR(9),' ') AS CMDT_DESC" ).append("\n"); 
		query.append("       ,REPLACE(REPLACE(CM.CSTMS_DESC,CHR(13)||CHR(10),' '),CHR(9),' ') AS CSTMS_DESC			" ).append("\n"); 
		query.append("       ,'' AS CN_CMDT            /*Chinese_commodity*/ " ).append("\n"); 
		query.append("       ,'' AS HS_CD              /*HS_code*/                   " ).append("\n"); 
		query.append("       ,'SML' AS CNTR_OPT        /*CNTR_OPERATOR*/          " ).append("\n"); 
		query.append("       ,CT.CNTR_NO               /*CONTAINER_NO*/       " ).append("\n"); 
		query.append("       ,CT.CNTR_TPSZ_CD          /*TP_SIZE*/       " ).append("\n"); 
		query.append("       ,SL.SEAL_NO AS SEAL_NO    /*SEAL_NO*/            " ).append("\n"); 
		query.append("       ,CT.CNTR_WGT              /*CNTR_WEIGHT*/       " ).append("\n"); 
		query.append("       ,CT.CNTR_MEAS_QTY AS CNTR_MEAS   /*CNTR_MEASURE*/ " ).append("\n"); 
		query.append("       ,RF.CDO_TEMP         " ).append("\n"); 
		query.append("       ,DG.IMDG_CLSS_CD     " ).append("\n"); 
		query.append("       ,DG.IMDG_UN_NO		" ).append("\n"); 
		query.append("       ,AK.OVR_DIM_FNT_LEN	" ).append("\n"); 
		query.append("       ,AK.OVR_DIM_REAR_LEN	" ).append("\n"); 
		query.append("       ,AK.OVR_HGT			" ).append("\n"); 
		query.append("       ,AK.OVR_DIM_LF_LEN	" ).append("\n"); 
		query.append("       ,AK.OVR_DIM_RT_LEN" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_CHN_BL BL," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_CNTR CT," ).append("\n"); 
		query.append("       BKG_CSTMS_SEAL_NO SL," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_CUST S, " ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_CUST C, " ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_CUST N," ).append("\n"); 
		query.append("       MDM_LOCATION POR," ).append("\n"); 
		query.append("       MDM_LOCATION POL," ).append("\n"); 
		query.append("       MDM_LOCATION DEL," ).append("\n"); 
		query.append("       MDM_LOCATION POD," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_RF RF," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_DG_CGO DG," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_AWK AK," ).append("\n"); 
		query.append("       BKG_BL_MK_DESC MARK," ).append("\n"); 
		query.append("       BKG_BL_DOC CM" ).append("\n"); 
		query.append("WHERE  BL.VSL_CD	            = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    BL.SKD_VOY_NO	        = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    BL.SKD_DIR_CD	        = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    DECODE(@[trans_mode],'O',BL.BKG_POL_CD,'D',BL.BKG_POD_CD,BL.BKG_POL_CD) = @[loc_cd]" ).append("\n"); 
		query.append("AND    DECODE(BL.BKG_CGO_TP_CD,'P','P','F') LIKE @[bkg_cgo_tp_cd]||'%'" ).append("\n"); 
		query.append("AND    BL.CHN_MF_SND_IND_CD 	LIKE @[trans_mode]||'%'" ).append("\n"); 
		query.append("AND    BL.BL_NO                 = CT.BL_NO" ).append("\n"); 
		query.append("AND    BL.CHN_MF_SND_IND_CD     = CT.CHN_MF_SND_IND_CD" ).append("\n"); 
		query.append("AND    CT.BL_NO                 = SL.BL_NO(+)" ).append("\n"); 
		query.append("AND    CT.CNTR_NO               = SL.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    SL.CNT_CD(+)         	= 'CN'" ).append("\n"); 
		query.append("AND    SL.CSTMS_DIV_ID(+)   	= 'CTM'" ).append("\n"); 
		query.append("AND    CT.CHN_MF_SND_IND_CD     = RF.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND    CT.BL_NO                 = RF.BL_NO(+)       " ).append("\n"); 
		query.append("AND    CT.CNTR_NO               = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    CT.CHN_MF_SND_IND_CD     = DG.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND    CT.BL_NO                 = DG.BL_NO(+)" ).append("\n"); 
		query.append("AND    CT.CNTR_NO               = DG.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    CT.CHN_MF_SND_IND_CD     = AK.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND    CT.BL_NO                 = AK.BL_NO(+)" ).append("\n"); 
		query.append("AND    CT.CNTR_NO               = AK.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    BL.CHN_MF_SND_IND_CD     = S.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND    BL.BL_NO                 = S.BL_NO(+)" ).append("\n"); 
		query.append("AND    S.BKG_CUST_TP_CD(+)      = 'S'" ).append("\n"); 
		query.append("AND    BL.CHN_MF_SND_IND_CD     = C.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND    BL.BL_NO                 = C.BL_NO(+)" ).append("\n"); 
		query.append("AND    C.BKG_CUST_TP_CD(+)      = 'C'" ).append("\n"); 
		query.append("AND    BL.CHN_MF_SND_IND_CD     = N.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND    BL.BL_NO                 = N.BL_NO(+)" ).append("\n"); 
		query.append("AND    N.BKG_CUST_TP_CD(+)	    = 'N'" ).append("\n"); 
		query.append("AND    BL.POR_CD                = POR.LOC_CD" ).append("\n"); 
		query.append("AND    BL.POL_CD                = POL.LOC_CD" ).append("\n"); 
		query.append("AND    BL.DEL_CD                = DEL.LOC_CD" ).append("\n"); 
		query.append("AND    BL.POD_CD                = POD.LOC_CD" ).append("\n"); 
		query.append("AND    BL.BKG_NO                = MARK.BKG_NO(+)" ).append("\n"); 
		query.append("AND    BL.BKG_NO                = CM.BKG_NO(+)" ).append("\n"); 
		query.append("AND    MARK.MK_SEQ(+)           = '01'" ).append("\n"); 
		query.append("ORDER BY 'SMLM'||BL.BL_NO, CT.CNTR_NO" ).append("\n"); 

	}
}