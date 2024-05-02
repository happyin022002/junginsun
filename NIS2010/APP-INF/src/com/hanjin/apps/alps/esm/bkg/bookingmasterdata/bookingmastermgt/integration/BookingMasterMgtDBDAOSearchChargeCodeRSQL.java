/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchChargeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.15 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchChargeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking에서 사용되는  MDM Charge Code를 조회한다
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchChargeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ipage",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onepagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchChargeCodeRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(SELECT COUNT(*) FROM MDM_CHARGE WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND CHG_CD LIKE UPPER(@[chg_cd])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_nm} != '')" ).append("\n"); 
		query.append("AND CHG_NM  LIKE UPPER(@[chg_nm])||'%'" ).append("\n"); 
		query.append("#end ) totcnt," ).append("\n"); 
		query.append("m.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM RN" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",CHG_NM" ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND CHG_CD LIKE '%'||UPPER(@[chg_cd])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_nm} != '')" ).append("\n"); 
		query.append("AND CHG_NM  LIKE '%'||UPPER(@[chg_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM <= @[ipage] * @[onepagerows]" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 
		query.append(") m" ).append("\n"); 
		query.append("WHERE RN > @[ipage] * @[onepagerows] - @[onepagerows]" ).append("\n"); 

	}
}