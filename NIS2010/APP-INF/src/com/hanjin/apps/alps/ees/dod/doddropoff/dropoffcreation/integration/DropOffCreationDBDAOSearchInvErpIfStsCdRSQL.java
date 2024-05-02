/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchInvErpIfStsCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.26 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchInvErpIfStsCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Correction AR INV 수행 전에 이전 AR INV 수행 건에 대한 I/F 상태값을 가져온다
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchInvErpIfStsCdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchInvErpIfStsCdRSQL").append("\n"); 
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
		query.append("SELECT NVL((SELECT INV_ERP_IF_STS_CD" ).append("\n"); 
		query.append("              FROM INV_AR_AMT" ).append("\n"); 
		query.append("             WHERE AR_IF_NO = (SELECT AR_IF_NO" ).append("\n"); 
		query.append("                          FROM DOD_DRP_OFF_CHG" ).append("\n"); 
		query.append("                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                           AND DRP_OFF_CHG_SEQ = @[drp_off_chg_seq] )), 'NODATA') INV_ERP_IF_STS_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}