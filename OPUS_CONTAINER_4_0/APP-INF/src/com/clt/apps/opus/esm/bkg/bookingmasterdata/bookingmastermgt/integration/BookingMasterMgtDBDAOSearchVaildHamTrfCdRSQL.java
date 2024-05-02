/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL").append("\n"); 
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
		query.append("--1. exp_dt 가 널이 2개 이상이면 안된다." ).append("\n"); 
		query.append("SELECT NVL(MAX(FLG),'N')" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 'Y' FLG FROM BKG_HAMO_TRF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND HAMO_TRF_CD =  @[hamo_trf_cd]" ).append("\n"); 
		query.append("AND HAMO_TP_CD = @[hamo_tp_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND '' IS NULL AND  EXP_DT IS NULL" ).append("\n"); 
		query.append("HAVING COUNT(1) > 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}