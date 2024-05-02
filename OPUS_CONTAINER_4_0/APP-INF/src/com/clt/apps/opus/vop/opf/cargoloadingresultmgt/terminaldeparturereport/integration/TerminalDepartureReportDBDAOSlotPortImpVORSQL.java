/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSlotPortImpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.09 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSlotPortImpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSlotPortImpVORSQL(){
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
		query.append("FileName : TerminalDepartureReportDBDAOSlotPortImpVORSQL").append("\n"); 
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
		query.append("SELECT  OPR_CD," ).append("\n"); 
		query.append("TRADE_FULL," ).append("\n"); 
		query.append("TRADE_MT," ).append("\n"); 
		query.append("(TRADE_FULL + TRADE_MT) AS TRADE_SUB_SLOT," ).append("\n"); 
		query.append("INTER_FULL," ).append("\n"); 
		query.append("INTER_MT," ).append("\n"); 
		query.append("TRADE_SUB_WGT," ).append("\n"); 
		query.append("INTER_SUB_WGT," ).append("\n"); 
		query.append("(INTER_FULL + INTER_MT) AS INTER_SUB_SLOT," ).append("\n"); 
		query.append("(TRADE_FULL + TRADE_MT + INTER_FULL + INTER_MT)  AS GRAND_TTL_SLOT," ).append("\n"); 
		query.append("(TRADE_SUB_WGT + INTER_SUB_WGT) AS GRAND_TTL_WGT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT	OPR_CD," ).append("\n"); 
		query.append("(FULL_OUT_20 + FULL_OUT_2H) + (FULL_OUT_40 + FULL_OUT_4H + FULL_OUT_45) * 2  AS TRADE_FULL," ).append("\n"); 
		query.append("(ET_OUT_20 + ET_OUT_2H) + (ET_OUT_40 + ET_OUT_4H + ET_OUT_45) * 2  AS TRADE_MT," ).append("\n"); 
		query.append("WT_OUT AS TRADE_SUB_WGT," ).append("\n"); 
		query.append("(FULL_IN_20 + FULL_IN_2H) + (FULL_IN_40 + FULL_IN_4H + FULL_IN_45) * 2  AS INTER_FULL," ).append("\n"); 
		query.append("(ET_IN_20 + ET_IN_2H) + (ET_IN_40 + ET_IN_4H + ET_IN_45) * 2  AS INTER_MT," ).append("\n"); 
		query.append("WT_IN AS INTER_SUB_WGT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT  OPR_CD," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_OUT_20," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_OUT_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_OUT_40," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_OUT_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_OUT_45," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_OUT_20," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_OUT_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_OUT_40," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_OUT_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_OUT_45," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LM',S.WEIGHT,0))                                  							WT_OUT," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'2',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_IN_20," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'3',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_IN_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'4',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_IN_40," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'H',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_IN_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'L',DECODE(S.CNTR_TYPE,'F',S.QTY,'R',S.QTY,0),0),0)) FULL_IN_45," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'2',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_IN_20," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'3',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_IN_2H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'4',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_IN_40," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'H',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_IN_4H," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',DECODE(S.CNTR_SIZE,'L',DECODE(S.CNTR_TYPE,'E',S.QTY,0),0),0))           ET_IN_45," ).append("\n"); 
		query.append("SUM(DECODE(S.STATUS,'LI',S.WEIGHT,0))                                  							WT_IN" ).append("\n"); 
		query.append("FROM    TDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND    VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND    DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND    CALL_IND=  @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    STATUS IN ('LI', 'LM')" ).append("\n"); 
		query.append("AND	   CNTR_TYPE NOT IN ('D', 'R', 'A')" ).append("\n"); 
		query.append("GROUP   BY OPR_CD" ).append("\n"); 
		query.append("ORDER   BY OPR_CD" ).append("\n"); 
		query.append(")X" ).append("\n"); 
		query.append(")Y" ).append("\n"); 
		query.append("ORDER BY OPR_CD" ).append("\n"); 

	}
}