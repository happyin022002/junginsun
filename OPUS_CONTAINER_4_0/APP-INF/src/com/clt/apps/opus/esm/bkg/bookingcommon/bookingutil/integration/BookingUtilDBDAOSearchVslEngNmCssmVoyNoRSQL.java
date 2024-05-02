/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchVslEngNmCssmVoyNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchVslEngNmCssmVoyNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VslEngNm + CssmVoyNo
	  * </pre>
	  */
	public BookingUtilDBDAOSearchVslEngNmCssmVoyNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchVslEngNmCssmVoyNoRSQL").append("\n"); 
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
		query.append("SELECT VSL_ENG_NM||' '||VSK.OB_CSSM_VOY_NO VVD" ).append("\n"); 
		query.append("           FROM MDM_VSL_CNTR MDM, VSK_VSL_PORT_SKD VSK, BKG_VVD VVD" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND VVD.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("             AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND VVD.POL_YD_CD = VSK.YD_CD" ).append("\n"); 
		query.append("             AND VVD.VSL_CD = MDM.VSL_CD" ).append("\n"); 
		query.append("             AND ROWNUM =1" ).append("\n"); 

	}
}