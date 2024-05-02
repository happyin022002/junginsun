/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEuDoRcvrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEuDoRcvrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EU_Cargo Release Order의 D/O Receiver Setting 및 Send와 Release를 할 수 있는 Pop-up화면에서 사용하는 SQL문(0937-01)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEuDoRcvrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no_split",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEuDoRcvrInfoRSQL").append("\n"); 
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
		query.append("SELECT BKDO.BKG_NO" ).append("\n"); 
		query.append(", BKDO.DO_NO" ).append("\n"); 
		query.append(", BKDO.DO_NO_SPLIT" ).append("\n"); 
		query.append(", BKDO.HBL_NO" ).append("\n"); 
		query.append(", NVL(TRIM(BKDO.RCVR_CNEE_NM), BCST.CUST_NM) AS RCVR_CNEE_NM" ).append("\n"); 
		query.append(", BKDO.RCVR_CO_NM" ).append("\n"); 
		query.append(", BKDO.RCVR_PHN_NO" ).append("\n"); 
		query.append(", BKDO.PIC_NM" ).append("\n"); 
		query.append(", NVL(TRIM(BKDO.RCVR_EML), BCST.CUST_EML) AS RCVR_EML" ).append("\n"); 
		query.append(", BKGM.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(", NVL(TRIM(BKDO.RCVR_FAX_NO), BCST.CUST_FAX_NO) AS RCVR_FAX_NO" ).append("\n"); 
		query.append("FROM BKG_DO BKDO" ).append("\n"); 
		query.append(", BKG_BOOKING BKGM" ).append("\n"); 
		query.append(", BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("WHERE BKDO.DO_NO = @[do_no]" ).append("\n"); 
		query.append("AND BKDO.DO_NO_SPLIT = nvl(@[do_no_split],'00')" ).append("\n"); 
		query.append("AND BKGM.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD IN DECODE (BKGM.CUST_TO_ORD_FLG,'Y', 'N', 'C')" ).append("\n"); 

	}
}