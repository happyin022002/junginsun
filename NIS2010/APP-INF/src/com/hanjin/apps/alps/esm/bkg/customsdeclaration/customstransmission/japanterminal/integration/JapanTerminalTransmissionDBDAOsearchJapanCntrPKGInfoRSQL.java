/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanCntrPKGInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2013.01.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanCntrPKGInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file japan container package 정보를 가져온다.
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanCntrPKGInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanCntrPKGInfoRSQL").append("\n"); 
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
		query.append("--PKG             " ).append("\n"); 
		query.append("--PUNIT           " ).append("\n"); 
		query.append("--WGT             " ).append("\n"); 
		query.append("--WUNIT           " ).append("\n"); 
		query.append("--MEAS            " ).append("\n"); 
		query.append("--MUNIT           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SUM(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(",MAX(PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append(",SUM(CNTR_WGT) CNTR_WGT" ).append("\n"); 
		query.append(",DECODE(NVL(MAX(WGT_UT_CD),'KGS'),'LBS','LBR','KGS','KGM',MAX(WGT_UT_CD) ) WGT_UT_CD" ).append("\n"); 
		query.append(",SUM(MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append(",DECODE(NVL(MAX(MEAS_UT_CD),'CBM'),'CMF','FTQ','MTQ') MEAS_UT_CD" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_CNTR JC" ).append("\n"); 
		query.append("WHERE JC.BKG_NO LIKE SUBSTR(@[bkg_no], 1, 10)||'%'" ).append("\n"); 
		query.append("AND JC.BKG_SKD_SEQ = 0" ).append("\n"); 

	}
}