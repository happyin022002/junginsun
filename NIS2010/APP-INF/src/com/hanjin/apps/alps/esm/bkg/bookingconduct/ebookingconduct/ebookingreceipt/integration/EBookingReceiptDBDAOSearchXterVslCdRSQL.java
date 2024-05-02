/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterVslCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterVslCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SEANACCS에서는 Call_sgn_no를 가지고 Vsl_Cd 값을 가지고 옴.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterVslCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterVslCdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT decode(sgn.cnt,1,mvc.VSL_CD,vvs.VSL_CD) VSL_CD, decode(sgn.cnt,1,SYSDATE,VVS.CRE_DT) CRE_DT" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR mvc, VSK_VSL_SKD vvs," ).append("\n"); 
		query.append("( SELECT count(*) cnt" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N' ) sgn" ).append("\n"); 
		query.append("WHERE mvc.CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("AND mvc.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND mvc.vsl_cd = vvs.VSL_CD(+)" ).append("\n"); 
		query.append("AND vvs.SKD_VOY_NO(+) = @[skd_voy_no]" ).append("\n"); 
		query.append("AND vvs.SKD_DIR_CD(+) = @[skd_dir_cd]" ).append("\n"); 
		query.append("ORDER BY vvs.CRE_DT desc )" ).append("\n"); 
		query.append("WHERE CRE_DT is not null" ).append("\n"); 
		query.append("AND rownum = 1" ).append("\n"); 

	}
}