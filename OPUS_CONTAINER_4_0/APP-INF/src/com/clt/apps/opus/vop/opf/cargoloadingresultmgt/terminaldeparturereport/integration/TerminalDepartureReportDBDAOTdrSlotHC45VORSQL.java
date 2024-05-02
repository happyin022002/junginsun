/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrSlotHC45VORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrSlotHC45VORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrSlotHC45VORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrSlotHC45VORSQL").append("\n"); 
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
		query.append("SELECT OPR_CD," ).append("\n"); 
		query.append("       HC_LD_20," ).append("\n"); 
		query.append("       HC_BSA_20," ).append("\n"); 
		query.append("       HC_OR_20," ).append("\n"); 
		query.append("       HC_ADD_20," ).append("\n"); 
		query.append("       HC_LD_40," ).append("\n"); 
		query.append("       HC_BSA_40," ).append("\n"); 
		query.append("       HC_OR_40," ).append("\n"); 
		query.append("       HC_ADD_40," ).append("\n"); 
		query.append("       HC_LD_45," ).append("\n"); 
		query.append("       HC_BSA_45," ).append("\n"); 
		query.append("       HC_UR_45," ).append("\n"); 
		query.append("       HC_OR_45," ).append("\n"); 
		query.append("       HC_ADD_45" ).append("\n"); 
		query.append("FROM   (SELECT DISTINCT" ).append("\n"); 
		query.append("               OPR_CD," ).append("\n"); 
		query.append("               HC_LD_20," ).append("\n"); 
		query.append("               HC_BSA_20," ).append("\n"); 
		query.append("               HC_OR_20," ).append("\n"); 
		query.append("               HC_ADD_20," ).append("\n"); 
		query.append("               HC_LD_40," ).append("\n"); 
		query.append("               HC_BSA_40," ).append("\n"); 
		query.append("               HC_OR_40," ).append("\n"); 
		query.append("               HC_ADD_40," ).append("\n"); 
		query.append("               HC_LD_45," ).append("\n"); 
		query.append("               HC_BSA_45," ).append("\n"); 
		query.append("               HC_UR_45," ).append("\n"); 
		query.append("               HC_OR_45," ).append("\n"); 
		query.append("               HC_ADD_45" ).append("\n"); 
		query.append("        FROM   ( SELECT B.OPR_CD," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL), NULL)) HC_LD_20," ).append("\n"); 
		query.append("                        HC20_QTY HC_BSA_20," ).append("\n"); 
		query.append("                        HC20_RAT HC_OR_20," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL))) HC_ADD_20," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL), NULL)) HC_LD_40," ).append("\n"); 
		query.append("                        HC40_QTY HC_BSA_40," ).append("\n"); 
		query.append("                        HC40_RAT HC_OR_40," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL))) HC_ADD_40," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL), NULL)) HC_LD_45," ).append("\n"); 
		query.append("                        QTY_45 HC_BSA_45," ).append("\n"); 
		query.append("                        UN_RAT_45 HC_UR_45," ).append("\n"); 
		query.append("                        OV_RAT_45 HC_OR_45," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL))) HC_ADD_45" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                        TDR_HEADER H," ).append("\n"); 
		query.append("                        TDR_UTILIZE C," ).append("\n"); 
		query.append("                        TDR_BSA B " ).append("\n"); 
		query.append("                 WHERE  V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                 AND    V.YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("                 AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 AND    V.VSL_CD = H.VSL_CD" ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = H.VOY_NO" ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = H.DIR_CD" ).append("\n"); 
		query.append("                 AND    V.VPS_PORT_CD = H.PORT_CD" ).append("\n"); 
		query.append("                 AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("                 AND    H.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                 AND    H.VOY_NO = B.VOY_NO(+)" ).append("\n"); 
		query.append("                 AND    H.DIR_CD = B.DIR_CD(+)" ).append("\n"); 
		query.append("                 AND    H.PORT_CD = B.PORT_CD(+)" ).append("\n"); 
		query.append("                 AND    H.CALL_IND = B.CALL_IND(+)" ).append("\n"); 
		query.append("                 AND    B.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("                 AND    B.VOY_NO = C.VOY_NO(+)" ).append("\n"); 
		query.append("                 AND    B.DIR_CD = C.DIR_CD(+)" ).append("\n"); 
		query.append("                 AND    B.PORT_CD = C.PORT_CD(+)" ).append("\n"); 
		query.append("                 AND    B.CALL_IND = C.CALL_IND(+)" ).append("\n"); 
		query.append("                 AND    B.OPR_CD = C.OPR_CD(+)" ).append("\n"); 
		query.append("                 GROUP BY B.OPR_CD, HC20_QTY, HC20_RAT, HC40_QTY, HC40_RAT, QTY_45, UN_RAT_45, OV_RAT_45" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT C.OPR_CD," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL), NULL)) HC_LD_20," ).append("\n"); 
		query.append("                        HC20_QTY HC_BSA_20," ).append("\n"); 
		query.append("                        HC20_RAT HC_OR_20," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, '3', C.QTY, NULL), NULL))) HC_ADD_20," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL), NULL)) HC_LD_40," ).append("\n"); 
		query.append("                        HC40_QTY HC_BSA_40," ).append("\n"); 
		query.append("                        HC40_RAT HC_OR_40," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'H', C.QTY, NULL), NULL))) HC_ADD_40," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'F', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), 'E', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL), NULL)) HC_LD_45," ).append("\n"); 
		query.append("                        QTY_45 HC_BSA_45," ).append("\n"); 
		query.append("                        UN_RAT_45 HC_UR_45," ).append("\n"); 
		query.append("                        OV_RAT_45 HC_OR_45," ).append("\n"); 
		query.append("                        SUM(DECODE(C.STATUS, 'SM', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL), 'SI', DECODE(C.CNTR_TYPE, 'A', DECODE(C.CNTR_SIZE, 'L', C.QTY, NULL), NULL))) HC_ADD_45" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD V," ).append("\n"); 
		query.append("                        TDR_HEADER H," ).append("\n"); 
		query.append("                        TDR_UTILIZE C," ).append("\n"); 
		query.append("                        TDR_BSA B " ).append("\n"); 
		query.append("                 WHERE  V.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                 AND    V.YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("                 AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                 AND    V.VSL_CD = H.VSL_CD" ).append("\n"); 
		query.append("                 AND    V.SKD_VOY_NO = H.VOY_NO" ).append("\n"); 
		query.append("                 AND    V.SKD_DIR_CD = H.DIR_CD" ).append("\n"); 
		query.append("                 AND    V.VPS_PORT_CD = H.PORT_CD" ).append("\n"); 
		query.append("                 AND    V.CLPT_IND_SEQ = H.CALL_IND" ).append("\n"); 
		query.append("                 AND    H.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("                 AND    H.VOY_NO = C.VOY_NO(+)" ).append("\n"); 
		query.append("                 AND    H.DIR_CD = C.DIR_CD(+)" ).append("\n"); 
		query.append("                 AND    H.PORT_CD = C.PORT_CD(+)" ).append("\n"); 
		query.append("                 AND    H.CALL_IND = C.CALL_IND(+)" ).append("\n"); 
		query.append("                 AND    C.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                 AND    C.VOY_NO = B.VOY_NO(+)" ).append("\n"); 
		query.append("                 AND    C.DIR_CD = B.DIR_CD(+)" ).append("\n"); 
		query.append("                 AND    C.PORT_CD = B.PORT_CD(+)" ).append("\n"); 
		query.append("                 AND    C.CALL_IND = B.CALL_IND(+)" ).append("\n"); 
		query.append("                 AND    C.OPR_CD = B.OPR_CD(+)  " ).append("\n"); 
		query.append("                 GROUP BY C.OPR_CD, HC20_QTY, HC20_RAT, HC40_QTY, HC40_RAT, QTY_45, UN_RAT_45, OV_RAT_45 )" ).append("\n"); 
		query.append("        WHERE OPR_CD IS NOT NULL )" ).append("\n"); 
		query.append(" ORDER BY OPR_CD" ).append("\n"); 

	}
}