/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchMarineYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.13 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchMarineYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pol, pod는 marine terminal이어야 한다
	  * </pre>
	  */
	public BookingUtilDBDAOSearchMarineYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ydCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchMarineYardRSQL").append("\n"); 
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
		query.append("select COUNT(1) CNT" ).append("\n"); 
		query.append("from mdm_yard" ).append("\n"); 
		query.append("where loc_cd = SUBSTR(@[locCd], 1, 5)" ).append("\n"); 
		query.append("#if (${ydCd}!= '')" ).append("\n"); 
		query.append("AND		YD_CD = @[ydCd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and YD_CHR_CD ='N'" ).append("\n"); 
		query.append("and (YD_FCTY_TP_MRN_TML_FLG = 'Y' or YD_FCTY_TP_BRG_RMP_FLG = 'Y')" ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}