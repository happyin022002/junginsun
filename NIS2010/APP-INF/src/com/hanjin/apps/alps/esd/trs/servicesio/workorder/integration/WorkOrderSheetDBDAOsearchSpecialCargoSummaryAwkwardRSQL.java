/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchSpecialCargoSummaryAwkwardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.28 
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

public class WorkOrderSheetDBDAOsearchSpecialCargoSummaryAwkwardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Special Cargo Summary Awkward
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchSpecialCargoSummaryAwkwardRSQL(){
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
		query.append("FileName : WorkOrderSheetDBDAOsearchSpecialCargoSummaryAwkwardRSQL").append("\n"); 
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
		query.append("ROW_ID                                    AS AWK_RNUM," ).append("\n"); 
		query.append("CNTR.EQ_NO                                AS AWK_EQ_NO," ).append("\n"); 
		query.append("AWK.TTL_DIM_LEN                           AS AWK_LENGTH," ).append("\n"); 
		query.append("AWK.TTL_DIM_WDT                           AS AWK_WIDTH," ).append("\n"); 
		query.append("AWK.TTL_DIM_HGT                           AS AWK_HEIGHT," ).append("\n"); 
		query.append("AWK.OVR_VOID_SLT_QTY                      AS AWK_VOID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SO.EQ_NO                                ," ).append("\n"); 
		query.append("SO.SPCL_CGO_CNTR_TP_CD                  ," ).append("\n"); 
		query.append("SO.BKG_NO                               ," ).append("\n"); 
		query.append("SO.TRO_SEQ                              ," ).append("\n"); 
		query.append("ROWNUM                                  AS ROW_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD                        WO," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD                        SO" ).append("\n"); 
		query.append("WHERE WO.TRSP_WO_OFC_CTY_CD                   = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ                          = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND (wo.TRSP_WO_OFC_CTY_CD,wo.TRSP_WO_SEQ)	= ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("#if (${wo_vndr_seq} != '')" ).append("\n"); 
		query.append("and   wo.wo_vndr_seq  =  @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") CNTR," ).append("\n"); 
		query.append("BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO                                 = AWK.BKG_NO" ).append("\n"); 
		query.append("AND   AWK.AWK_CGO_SEQ                       = DECODE(SUBSTR(CNTR.TRO_SEQ,2,1)" ).append("\n"); 
		query.append(",'E',TO_NUMBER(SUBSTR(CNTR.TRO_SEQ,3,LENGTH(CNTR.TRO_SEQ)-4))" ).append("\n"); 
		query.append(",AWK.AWK_CGO_SEQ)" ).append("\n"); 
		query.append("AND   NVL(CNTR.EQ_NO,'-STORMBOY-')          = DECODE(SUBSTR(CNTR.TRO_SEQ,2,1),'E'" ).append("\n"); 
		query.append(",NVL(CNTR.EQ_NO,'-STORMBOY-'),AWK.CNTR_NO)" ).append("\n"); 
		query.append("AND   NVL(CNTR.SPCL_CGO_CNTR_TP_CD,'-STORMBOY-')" ).append("\n"); 
		query.append("=  DECODE(SUBSTR(CNTR.TRO_SEQ,2,1),'E'" ).append("\n"); 
		query.append(",NVL(CNTR.SPCL_CGO_CNTR_TP_CD,'-STORMBOY-'),'AK')" ).append("\n"); 

	}
}