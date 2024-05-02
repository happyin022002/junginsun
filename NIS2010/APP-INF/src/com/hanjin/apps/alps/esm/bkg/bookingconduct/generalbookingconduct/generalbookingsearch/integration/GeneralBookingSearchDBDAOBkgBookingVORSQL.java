/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOBkgBookingVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOBkgBookingVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOBkgBookingVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOBkgBookingVORSQL").append("\n"); 
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
		query.append("select  org_sconti_cd," ).append("\n"); 
		query.append("        dest_sconti_cd," ).append("\n"); 
		query.append("        org_trns_svc_mod_cd," ).append("\n"); 
		query.append("        dest_trns_svc_mod_cd," ).append("\n"); 
		query.append("        blck_stwg_cd," ).append("\n"); 
		query.append("        ( SELECT DEST_NOD_CD " ).append("\n"); 
		query.append("          FROM   PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("          WHERE  DTL.PCTL_NO        = BK.PCTL_NO" ).append("\n"); 
		query.append("          AND    DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("          AND    DTL.MTY_YD_FLG     = 'Y'" ).append("\n"); 
		query.append("          AND    PCTL_IO_BND_CD     = 'I'" ).append("\n"); 
		query.append("          AND    ROWNUM = 1 ) ESTM_IB_MTY_RTN_YD_CD" ).append("\n"); 
		query.append("from    bkg_booking bk" ).append("\n"); 
		query.append("where   bk.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}