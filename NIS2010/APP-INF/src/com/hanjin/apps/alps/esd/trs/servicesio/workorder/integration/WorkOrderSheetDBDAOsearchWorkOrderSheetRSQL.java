/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderSheetDBDAOsearchWorkOrderSheetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Work Order Sheet
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchWorkOrderSheetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("WO.WO_VNDR_SEQ                             AS VNDR_CODE," ).append("\n"); 
		query.append("VD.VNDR_LGL_ENG_NM                         AS Full_Name," ).append("\n"); 
		query.append("VD.ENG_ADDR                                AS ENG_ADDR," ).append("\n"); 
		query.append("VD_CNTC.PHN_NO                             AS PHN_NO," ).append("\n"); 
		query.append("VD_CNTC.FAX_NO                             AS FAX_NO," ).append("\n"); 
		query.append("VD.CNTC_PSON_NM                            AS CNTC_PSON_NM," ).append("\n"); 
		query.append("SO.TRSP_BND_CD                             AS TRSP_BND_CD," ).append("\n"); 
		query.append("SO.TRSP_COST_DTL_MOD_CD                    AS TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("(select	intg_cd_val_dp_desc	from com_intg_cd_dtl  where	intg_cd_id = 'CD00283' and	intg_cd_val_ctnt = SO.TRSP_CRR_MOD_CD)     AS TRSP_CRR_MOD_NM," ).append("\n"); 
		query.append("(select	intg_cd_val_dp_desc	from com_intg_cd_dtl  where	intg_cd_id = 'CD00744' and	intg_cd_val_ctnt = SO.TRSP_COST_DTL_MOD_CD)     AS TRSP_COST_DTL_MOD_NM," ).append("\n"); 
		query.append("NVL(WO.TRSP_WO_OFC_CTY_CD,'')||NVL(WO.TRSP_WO_SEQ,'')                  											AS TRSP_WO_CD," ).append("\n"); 
		query.append("DECODE (WO.WO_ISS_STS_CD, 'I','Issue','R', 'Reissue','C','Correction','N','Cancellation')    AS WO_ISS_STS_CD," ).append("\n"); 
		query.append("FROM_YARD.YD_CD                            AS FM_CD," ).append("\n"); 
		query.append("FROM_YARD.YD_NM                            AS FM_NM," ).append("\n"); 
		query.append("FROM_YARD.YD_ADDR                          AS FM_ADDR," ).append("\n"); 
		query.append("FROM_YARD.PHN_NO                           AS FM_PHN_NO," ).append("\n"); 
		query.append("FROM_YARD.FAX_NO                           AS FM_FAX_NO," ).append("\n"); 
		query.append("FROM_YARD.YD_PIC_NM                        AS FM_PIC_NM," ).append("\n"); 
		query.append("TO_YARD.YD_CD                              AS TO_CD," ).append("\n"); 
		query.append("TO_YARD.YD_NM                              AS TO_NM," ).append("\n"); 
		query.append("TO_YARD.YD_ADDR                            AS TO_ADDR," ).append("\n"); 
		query.append("TO_YARD.PHN_NO                             AS TO_PHN_NO," ).append("\n"); 
		query.append("TO_YARD.FAX_NO                             AS TO_FAX_NO," ).append("\n"); 
		query.append("TO_YARD.YD_PIC_NM                          AS TO_PIC_NM," ).append("\n"); 
		query.append("VIA_YARD.YD_CD                             AS VIA_CD," ).append("\n"); 
		query.append("VIA_YARD.YD_NM                             AS VIA_NM," ).append("\n"); 
		query.append("VIA_YARD.YD_ADDR                           AS VIA_ADDR," ).append("\n"); 
		query.append("VIA_YARD.PHN_NO                            AS VIA_PHN_NO," ).append("\n"); 
		query.append("VIA_YARD.FAX_NO                            AS VIA_FAX_NO," ).append("\n"); 
		query.append("VIA_YARD.YD_PIC_NM                         AS VIA_PIC_NM," ).append("\n"); 
		query.append("SO.DOR_NOD_CD                              AS DR_CD," ).append("\n"); 
		query.append("SO.DOR_DE_ADDR                             AS DR_ADDR," ).append("\n"); 
		query.append("SO.FCTRY_NM                                AS DR_NM," ).append("\n"); 
		query.append("SO.CNTC_PSON_PHN_NO                        AS DR_PHN_NO," ).append("\n"); 
		query.append("SO.CNTC_PSON_FAX_NO                        AS DR_FAX_NO," ).append("\n"); 
		query.append("SO.CNTC_PSON_NM                            AS DR_PIC_NM," ).append("\n"); 
		query.append("WO.WO_RMK                                  AS Instruction," ).append("\n"); 
		query.append("IB_VVD.VSL_ENG_NM ||' '||SUBSTR(SO.IB_VVD_CD,5,6) AS IB_VVD_CD," ).append("\n"); 
		query.append("OB_VVD.VSL_ENG_NM ||' '||SUBSTR(SO.OB_VVD_CD,5,6) AS OB_VVD_CD," ).append("\n"); 
		query.append("SO.FDR_VSL_CD||SO.FDR_SKD_VOY_NO||SO.FDR_SKD_DIR_CD AS Feeder_VVD," ).append("\n"); 
		query.append("ORG.OFC_ADDR                               AS OFC_ADDR," ).append("\n"); 
		query.append("ORG.OFC_PHN_NO                             AS OFC_PHN_NO," ).append("\n"); 
		query.append("ORG.OFC_FAX_NO                             AS OFC_FAX_NO," ).append("\n"); 
		query.append("USR.USR_NM                                 AS PIC," ).append("\n"); 
		query.append("TO_CHAR(WO.LOCL_CRE_DT,'YYYY-MM-DD HH24:MI')  AS WO_ISS_AT," ).append("\n"); 
		query.append("NVL(to_char(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(WO.CRE_OFC_CD),'YYYY-MM-DD HH24:MI'),to_char(sysdate,'YYYY-MM-DD HH24:MI'))  as print_at," ).append("\n"); 
		query.append("(SELECT LC.CONTI_CD AS MAE_FLG FROM MDM_LOCATION LC WHERE SUBSTR(SO.FM_NOD_CD,1,5) = LC.LOC_CD) AS MAE_FLG," ).append("\n"); 
		query.append("WO.CRE_OFC_CD                              AS CRE_OFC_CD," ).append("\n"); 
		query.append("WO.CRE_USR_ID                              AS CRE_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD                            SO," ).append("\n"); 
		query.append("MDM_VENDOR                                  VD," ).append("\n"); 
		query.append("MDM_VNDR_CNTC_PNT                           VD_CNTC," ).append("\n"); 
		query.append("MDM_YARD                                    FROM_YARD," ).append("\n"); 
		query.append("MDM_YARD                                    TO_YARD," ).append("\n"); 
		query.append("MDM_YARD                                    VIA_YARD," ).append("\n"); 
		query.append("MDM_ORGANIZATION                            ORG," ).append("\n"); 
		query.append("COM_USER                                    USR," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD                            WO," ).append("\n"); 
		query.append("MDM_VSL_CNTR                                IB_VVD," ).append("\n"); 
		query.append("MDM_VSL_CNTR                                OB_VVD" ).append("\n"); 
		query.append("WHERE WO.TRSP_WO_OFC_CTY_CD                   = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ                          = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND WO.CRE_OFC_CD                           = ORG.OFC_CD" ).append("\n"); 
		query.append("AND WO.WO_VNDR_SEQ                          = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND VD.VNDR_SEQ                             = VD_CNTC.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND VD_CNTC.PRMRY_CHK_FLG (+)               = 'Y'" ).append("\n"); 
		query.append("AND VD_CNTC.PHN_NO (+)                      IS NOT NULL" ).append("\n"); 
		query.append("AND VD.DELT_FLG                             = 'N'" ).append("\n"); 
		query.append("AND VD_CNTC.DELT_FLG (+)                    = 'N'" ).append("\n"); 
		query.append("AND SO.FM_NOD_CD                            = FROM_YARD.YD_CD(+)" ).append("\n"); 
		query.append("AND SO.TO_NOD_CD                            = TO_YARD.YD_CD(+)" ).append("\n"); 
		query.append("AND SO.VIA_NOD_CD                           = VIA_YARD.YD_CD(+)" ).append("\n"); 
		query.append("AND WO.CRE_USR_ID                           = USR.USR_ID" ).append("\n"); 
		query.append("AND SUBSTR(SO.IB_VVD_CD,0,4) 				  = IB_VVD.VSL_CD(+)" ).append("\n"); 
		query.append("AND SUBSTR(SO.OB_VVD_CD,0,4) 				  = OB_VVD.VSL_CD(+)" ).append("\n"); 
		query.append("#if (${wo_vndr_seq} != '')" ).append("\n"); 
		query.append("and   WO.wo_vndr_seq  =  @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($trsp_wo_ofc_cty_cd.size() > 0)" ).append("\n"); 
		query.append("AND (wo.trsp_wo_ofc_cty_cd,wo.trsp_wo_seq) in (" ).append("\n"); 
		query.append("#foreach($wonoKey in ${trsp_wo_ofc_cty_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $trsp_wo_ofc_cty_cd.size())" ).append("\n"); 
		query.append("(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}