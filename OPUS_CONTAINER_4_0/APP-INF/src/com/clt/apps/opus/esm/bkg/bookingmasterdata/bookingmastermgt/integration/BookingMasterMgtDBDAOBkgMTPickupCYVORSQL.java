/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgMTPickupCYVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.11.18 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgMTPickupCYVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgMTPickupCYVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgMTPickupCYVORSQL").append("\n"); 
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
		query.append("SELECT A.YD_CD" ).append("\n"); 
		query.append("      ,A.FCAST_DT" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CNTR_AVAL_FCAST_TP_CD" ).append("\n"); 
		query.append("      ,A.CO_CD" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(NVL(FCAST_QTY,0))" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT))) FCAST_QTY" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 1)) FCAST_QTY1" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 2)) FCAST_QTY2" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 3)) FCAST_QTY3" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 4)) FCAST_QTY4" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 5)) FCAST_QTY5" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 6)) FCAST_QTY6" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 7)) FCAST_QTY7" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 8)) FCAST_QTY8" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 9)) FCAST_QTY9" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 10)) FCAST_QTY10" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 11)) FCAST_QTY11" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C" ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 12)) FCAST_QTY12" ).append("\n"); 
		query.append("      ,MAX((SELECT SUM(FCAST_QTY)" ).append("\n"); 
		query.append("        FROM   CIM_AVAL_SMRY C " ).append("\n"); 
		query.append("        WHERE  C.YD_CD = A.YD_CD AND C.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD AND C.CO_CD = A.CO_CD AND C.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD AND TRUNC(C.FCAST_DT) = TRUNC(A.FCAST_DT) + 13)) FCAST_QTY13" ).append("\n"); 
		query.append("FROM   CIM_AVAL_SMRY A" ).append("\n"); 
		query.append("WHERE  1 = 1 " ).append("\n"); 
		query.append("AND    YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND    CNTR_AVAL_FCAST_TP_CD = 'EA' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--AND    TRUNC(A.FCAST_DT) = TRUNC(SYSDATE)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/**" ).append("\n"); 
		query.append("	테스트를 위해 아래 적용된 조건" ).append("\n"); 
		query.append("**/" ).append("\n"); 
		query.append("AND    TRUNC(A.FCAST_DT) = ( SELECT TRUNC(MIN(B.FCAST_DT)) " ).append("\n"); 
		query.append("                           FROM    CIM_AVAL_SMRY B" ).append("\n"); 
		query.append("                           WHERE   1 = 1 " ).append("\n"); 
		query.append("                           AND     B.YD_CD = A.YD_CD " ).append("\n"); 
		query.append("                           AND     B.CNTR_AVAL_FCAST_TP_CD = A.CNTR_AVAL_FCAST_TP_CD)" ).append("\n"); 
		query.append("GROUP BY A.YD_CD" ).append("\n"); 
		query.append("        ,A.FCAST_DT" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.CNTR_AVAL_FCAST_TP_CD" ).append("\n"); 
		query.append("        ,A.CO_CD" ).append("\n"); 
		query.append("ORDER BY A.YD_CD" ).append("\n"); 
		query.append("        ,A.FCAST_DT" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.CNTR_AVAL_FCAST_TP_CD" ).append("\n"); 
		query.append("        ,A.CO_CD" ).append("\n"); 

	}
}