/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOSearchBDRBookingNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.11.17 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBDRBookingNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0727
	  * BDR Booking No Status - Inquiry
	  * BDR Status Inquiry에서 보여지는 Pop-up으로 선택된 BDR에 연관된 BKG Details을 보여주는 화면
	  * </pre>
	  */
	public StatusReportDBDAOSearchBDRBookingNoListRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBDRBookingNoListRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || DECODE(A.BL_NO_TP,'0','',A.BL_NO_TP)   BL_NO" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD           T_VVD" ).append("\n"); 
		query.append(",      NULL                                               P_VVD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      C.BDR_FLG" ).append("\n"); 
		query.append(",      'T' DATA_TYPE" ).append("\n"); 
		query.append(",	   '' VVD_CD" ).append("\n"); 
		query.append(",      A.SLAN_CD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A" ).append("\n"); 
		query.append(",      BKG_BL_DOC C" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    NVL(A.PRE_RLY_PORT_CD, A.POL_CD) = @[pol_cd]" ).append("\n"); 
		query.append("AND    NVL(A.PST_RLY_PORT_CD, A.POD_CD) = @[pod_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.BKG_STS_CD IN ('F', 'S', 'W')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",	   A.BL_NO || DECODE(A.BL_NO_TP,'0','',A.BL_NO_TP)  BL_NO" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD P_VVD" ).append("\n"); 
		query.append(",A.BKG_STS_CD" ).append("\n"); 
		query.append(",C.BDR_FLG" ).append("\n"); 
		query.append(",'F' DATA_TYPE" ).append("\n"); 
		query.append(",'' VVD_CD" ).append("\n"); 
		query.append(",A.SLAN_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM   BKG_VVD B" ).append("\n"); 
		query.append(",      BKG_BOOKING A" ).append("\n"); 
		query.append(",      BKG_BL_DOC C" ).append("\n"); 
		query.append("WHERE  B.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("AND    B.VSL_SEQ = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_STS_CD IN ('F', 'S', 'W')" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    B.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND    B.POD_CD = @[pod_cd]" ).append("\n"); 

	}
}