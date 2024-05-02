/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOVesselVoyageDirectionEqualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOVesselVoyageDirectionEqualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VesselVoyageDirectionEqual
	  * </pre>
	  */
	public BookingUtilDBDAOVesselVoyageDirectionEqualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_text",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOVesselVoyageDirectionEqualRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	DECODE(A1.VSL_NM ,A3.VSL_ENG_NM||' '||VSK.OB_CSSM_VOY_NO ,'T','F') AS OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_BL_DOC A1,BKG_VVD A2,MDM_VSL_CNTR A3 , VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("	AND A1.BKG_NO = @[input_text]" ).append("\n"); 
		query.append("	AND A2.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	AND A2.VSL_CD = A3.VSL_CD" ).append("\n"); 
		query.append("	AND A2.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("	AND A2.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A2.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A2.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("	AND A2.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	AND ROWNUM =1 " ).append("\n"); 

	}
}