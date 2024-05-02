/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchSpecialCargoSummaryDGRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.13 
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

public class WorkOrderSheetDBDAOsearchSpecialCargoSummaryDGRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Special Cargo Summary DG
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchSpecialCargoSummaryDGRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderSheetDBDAOsearchSpecialCargoSummaryDGRSQL").append("\n"); 
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
		query.append("ROW_ID                                    AS DG_RNUM," ).append("\n"); 
		query.append("CNTR.EQ_NO                                AS DG_EQ_NO," ).append("\n"); 
		query.append("DG.HCDG_FLG                          AS DG_HCDG," ).append("\n"); 
		query.append("DG.IMDG_UN_NO                             AS DG_UN_NO ," ).append("\n"); 
		query.append("DG.IMDG_CLSS_CD                      AS DG_IMO_CLASS," ).append("\n"); 
		query.append("DG.IMDG_SUBS_RSK_LBL_CD1             AS DG_SUB_LABEL," ).append("\n"); 
		query.append("DG.FLSH_PNT_CDO_TEMP            AS DG_FLASH_POINT," ).append("\n"); 
		query.append("DG.IMDG_PCK_GRP_CD                   AS DG_PGK_GRP," ).append("\n"); 
		query.append("DG.EMS_NO                            AS DG_EMS_NO," ).append("\n"); 
		query.append("DG.PRP_SHP_NM                        AS DG_PROP_SHIP_NM," ).append("\n"); 
		query.append("DG.HZD_DESC                          AS DG_HAZ_CONTS," ).append("\n"); 
		query.append("DG.OUT_IMDG_PCK_QTY1||'/'||DG.OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("AS DG_OUTER_PKG_QTY_TYPE," ).append("\n"); 
		query.append("DG.IN_IMDG_PCK_QTY1||'/'||DG.IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("AS DG_INNER_PKG_QTY_TYPE," ).append("\n"); 
		query.append("DG.GRS_WGT||'/'||DG.NET_WGT||'('||DG.WGT_UT_CD||')'" ).append("\n"); 
		query.append("AS DG_GROS_NET_WEIGHT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SO.EQ_NO                                ," ).append("\n"); 
		query.append("SO.BKG_NO AS BKG_NO                     ," ).append("\n"); 
		query.append("SO.TRO_SEQ                           ," ).append("\n"); 
		query.append("SO.SPCL_CGO_CNTR_TP_CD                  ," ).append("\n"); 
		query.append("ROWNUM AS ROW_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD                        WO," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD                        SO" ).append("\n"); 
		query.append("WHERE    WO.TRSP_WO_OFC_CTY_CD                   = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ                          = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND (wo.TRSP_WO_OFC_CTY_CD,wo.TRSP_WO_SEQ)	= ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("#if (${wo_vndr_seq} != '')" ).append("\n"); 
		query.append("and   wo.wo_vndr_seq  =  @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") CNTR," ).append("\n"); 
		query.append("BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CNTR.BKG_NO                                 = DG.BKG_NO" ).append("\n"); 
		query.append("AND   DG.DCGO_SEQ                           = DECODE(SUBSTR(CNTR.TRO_SEQ,2,1),'E'" ).append("\n"); 
		query.append(",TO_NUMBER(SUBSTR(CNTR.TRO_SEQ,3,LENGTH(CNTR.TRO_SEQ)-4)),DG.DCGO_SEQ)" ).append("\n"); 
		query.append("AND   NVL(CNTR.EQ_NO,'-STORMBOY-')          = DECODE(SUBSTR(CNTR.TRO_SEQ,2,1),'E'" ).append("\n"); 
		query.append(",NVL(CNTR.EQ_NO,'-STORMBOY-'),DG.CNTR_NO)" ).append("\n"); 
		query.append("AND   NVL(SPCL_CGO_CNTR_TP_CD,'-STORMBOY-') = DECODE(SUBSTR(CNTR.TRO_SEQ,2,1),'E'" ).append("\n"); 
		query.append(",NVL(SPCL_CGO_CNTR_TP_CD,'-STORMBOY-'),'DG')" ).append("\n"); 

	}
}