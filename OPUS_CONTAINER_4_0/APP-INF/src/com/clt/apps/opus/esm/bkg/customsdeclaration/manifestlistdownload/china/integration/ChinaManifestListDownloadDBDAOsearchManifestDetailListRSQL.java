/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchManifestDetailListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier :
*@LastVersion : 1.0
* 2014.10.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchManifestDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ChinaManifestDetailListVO
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchManifestDetailListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchManifestDetailListRSQL").append("\n");
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
		query.append("SELECT  '' AS SVC_PVD,             /*SERVICE_PROVIDER*/" ).append("\n");
		query.append("        COM_ConstantMgr_PKG.COM_getScacCode_FNC()||BKG.BL_NO AS BL,   /*BL*/" ).append("\n");
		query.append("        BL.POR_NM AS POR,          /*POR*/" ).append("\n");
		query.append("        BL.POL_NM AS POL,          /*POL*/" ).append("\n");
		query.append("        BL.POD_NM AS POD,          /*POD*/" ).append("\n");
		query.append("        BL.DEL_NM AS DEL,          /*DEL*/" ).append("\n");
		query.append("        DECODE(NVL(BL.WGT_UT_CD,' '),'LBS',ROUND(NVL(BL.ACT_WGT,0)*0.4536,3), NVL(BL.ACT_WGT,0)) AS WGT," ).append("\n");
		query.append("        NVL(BL.PCK_QTY,0) AS PCK," ).append("\n");
		query.append("        NVL(BL.MEAS_QTY,0) AS MEAS," ).append("\n");
		query.append("        REPLACE(REPLACE(S.CUST_ADDR,CHR(10),' '),CHR(9),' ') AS SHPR, /*Shipper*/" ).append("\n");
		query.append("        REPLACE(REPLACE(C.CUST_ADDR,CHR(10),' '),CHR(9),' ') AS CNEE, /*Consignee*/" ).append("\n");
		query.append("        REPLACE(REPLACE(N.CUST_ADDR,CHR(10),' '),CHR(9),' ') AS NTFY, /*Notify*/" ).append("\n");
		query.append("        REPLACE(REPLACE(REPLACE(MARK.MK_DESC, CHR(34), CHR(34)||CHR(34)),CHR(10),' '),CHR(9),' ') AS MK_DESC," ).append("\n");
		query.append("        REPLACE(REPLACE(REPLACE(MARK.CMDT_DESC, CHR(34), CHR(34)||CHR(34)),CHR(10),' '),CHR(9),' ') AS CMDT_DESC," ).append("\n");
		query.append("        REPLACE(REPLACE(BL.CSTMS_DESC,CHR(10),' '),CHR(9),' ') AS CSTMS_DESC," ).append("\n");
		query.append("        '' AS CN_CMDT,      /*Chinese_commodity*/" ).append("\n");
		query.append("        '' AS HS_CD,        /*HS_code*/" ).append("\n");
		query.append("        COM_ConstantMgr_PKG.COM_getScacCode_FNC() AS CNTR_OPT,  /*CNTR_OPERATOR*/" ).append("\n");
		query.append("        SC.CNTR_NO,         /*CONTAINER_NO*/" ).append("\n");
		query.append("        SC.CNTR_TPSZ_CD,    /*TP_SIZE*/" ).append("\n");
		query.append("        NVL(SEAL.CNTR_SEAL_NO, ' ') AS SEAL_NO, /*SEAL_NO*/" ).append("\n");
		query.append("        DECODE(NVL(SC.WGT_UT_CD, ' '),'LBS',ROUND(NVL(SC.CNTR_WGT, 0)*0.4536,3),NVL(SC.CNTR_WGT, 0)) AS CNTR_WGT, /*CNTR_WEIGHT*/" ).append("\n");
		query.append("        SC.MEAS_QTY AS CNTR_MEAS, /*CNTR_MEASURE*/" ).append("\n");
		query.append("        RF.CDO_TEMP," ).append("\n");
		query.append("        DG.IMDG_CLSS_CD," ).append("\n");
		query.append("        DG.IMDG_UN_NO," ).append("\n");
		query.append("        AK.OVR_FWRD_LEN," ).append("\n");
		query.append("        AK.OVR_BKWD_LEN," ).append("\n");
		query.append("        AK.OVR_HGT," ).append("\n");
		query.append("        AK.OVR_LF_LEN," ).append("\n");
		query.append("        AK.OVR_RT_LEN" ).append("\n");
		query.append("FROM    BKG_VVD VVD," ).append("\n");
		query.append("        BKG_BL_DOC BL," ).append("\n");
		query.append("        BKG_BOOKING BKG," ).append("\n");
		query.append("        BKG_CONTAINER SC," ).append("\n");
		query.append("        BKG_CNTR_SEAL_NO SEAL," ).append("\n");
		query.append("        BKG_CUSTOMER S," ).append("\n");
		query.append("        BKG_CUSTOMER C," ).append("\n");
		query.append("        BKG_CUSTOMER N," ).append("\n");
		query.append("        MDM_LOCATION LOC_POD," ).append("\n");
		query.append("        BKG_RF_CGO RF,--ts_seq확인해야됨" ).append("\n");
		query.append("        BKG_DG_CGO DG," ).append("\n");
		query.append("        BKG_AWK_CGO AK," ).append("\n");
		query.append("        BKG_BL_MK_DESC MARK" ).append("\n");
		query.append("WHERE  VVD.BKG_NO           =    BKG.BKG_NO" ).append("\n");
		query.append("AND    VVD.BKG_NO           =    BL.BKG_NO" ).append("\n");
		query.append("AND    VVD.VSL_CD           =    SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("AND    VVD.SKD_VOY_NO       =    SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("AND    VVD.SKD_DIR_CD       =    SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("AND    BKG.BKG_STS_CD       NOT IN ('X','S')" ).append("\n");
		query.append("AND    DECODE(BKG.BKG_CGO_TP_CD,'P','P','F') LIKE @[bkg_cgo_tp_cd]||'%'" ).append("\n");
		query.append("AND    DECODE(@[trans_mode],'D',VVD.POD_CD,'O',VVD.POL_CD,VVD.POL_CD) = @[loc_cd]" ).append("\n");
		query.append("AND    VVD.POD_CD           LIKE    DECODE(@[trans_mode],'D','%','O','CN%','%')" ).append("\n");
		query.append("AND    BKG.BKG_NO           =    SC.BKG_NO(+)" ).append("\n");
		query.append("AND    SC.BKG_NO            =    SEAL.BKG_NO(+)" ).append("\n");
		query.append("AND    SC.CNTR_NO           =    SEAL.CNTR_NO(+)" ).append("\n");
		query.append("AND    SC.BKG_NO            =    RF.BKG_NO(+)" ).append("\n");
		query.append("AND    SC.CNTR_NO           =    RF.CNTR_NO(+)" ).append("\n");
		query.append("AND    SC.BKG_NO            =    DG.BKG_NO(+)" ).append("\n");
		query.append("AND    SC.CNTR_NO           =    DG.CNTR_NO(+)" ).append("\n");
		query.append("AND    SC.BKG_NO            =    AK.BKG_NO(+)" ).append("\n");
		query.append("AND    SC.CNTR_NO           =    AK.CNTR_NO(+)" ).append("\n");
		query.append("AND    BKG.BKG_NO           =    S.BKG_NO(+)" ).append("\n");
		query.append("AND    BKG.BKG_NO           =    C.BKG_NO(+)" ).append("\n");
		query.append("AND    BKG.BKG_NO           =    N.BKG_NO(+)" ).append("\n");
		query.append("AND    VVD.POD_CD           =    LOC_POD.LOC_CD" ).append("\n");
		query.append("AND    BKG.BKG_NO           =    MARK.BKG_NO(+)" ).append("\n");
		query.append("AND    S.BKG_CUST_TP_CD(+)  =    'S'" ).append("\n");
		query.append("AND    C.BKG_CUST_TP_CD(+)  =    'C'" ).append("\n");
		query.append("AND    N.BKG_CUST_TP_CD(+)  =    'N'" ).append("\n");
		query.append("AND    MARK.MK_SEQ(+)       =    '01'" ).append("\n");
		query.append("ORDER BY COM_ConstantMgr_PKG.COM_getScacCode_FNC()||BKG.BL_NO, SC.CNTR_NO" ).append("\n");

	}
}