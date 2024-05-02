/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchIdaDoRcvrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchIdaDoRcvrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Delivery - D/O (India)Receiver and Actual Consignee Setting(UI_BKG-0936)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchIdaDoRcvrInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchIdaDoRcvrInfoRSQL").append("\n"); 
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
		query.append(", BKDO.RCVR_CNEE_NM" ).append("\n"); 
		query.append(", BKDO.RCVR_CO_NM" ).append("\n"); 
		query.append(", BKDO.RCVR_PHN_NO" ).append("\n"); 
		query.append(", BKDO.PIC_NM" ).append("\n"); 
		query.append(", BKDO.RCVR_EML" ).append("\n"); 
		query.append(", BKGM.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(", BKDO.RCVR_FAX_NO" ).append("\n"); 
		query.append("FROM BKG_DO BKDO" ).append("\n"); 
		query.append(", BKG_BOOKING BKGM" ).append("\n"); 
		query.append("WHERE BKDO.DO_NO = @[do_no]" ).append("\n"); 
		query.append("AND BKDO.DO_NO_SPLIT = NVL(TRIM(@[do_no_split]), '00')" ).append("\n"); 
		query.append("AND BKGM.BKG_NO = BKDO.BKG_NO" ).append("\n"); 

	}
}