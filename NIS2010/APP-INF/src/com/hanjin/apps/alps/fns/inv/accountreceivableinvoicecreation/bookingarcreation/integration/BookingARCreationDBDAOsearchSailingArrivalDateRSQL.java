/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchSailingArrivalDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.11.19 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchSailingArrivalDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSailingArrivalDate
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchSailingArrivalDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_indiv_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchSailingArrivalDateRSQL").append("\n"); 
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
		query.append("SELECT DECODE(DECODE(@[cng_indiv_cd], 'O', B.VPS_ETD_DT, B.VPS_ETA_DT), NULL, TO_CHAR(B.VPS_ETB_DT, 'YYYYMMDD'), TO_CHAR(DECODE(@[cng_indiv_cd], 'O', B.VPS_ETD_DT, B.VPS_ETA_DT),'YYYYMMDD')) EX_RATE_DATE" ).append("\n"); 
		query.append("FROM   BKG_VVD A,  VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("(SELECT BV.VSL_PRE_PST_CD X_BV_IND, DECODE(@[cng_indiv_cd], 'O', MAX(VPS.CLPT_IND_SEQ), MIN(VPS.CLPT_IND_SEQ)) X_CALL_IND" ).append("\n"); 
		query.append("FROM   BKG_VVD BV , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("WHERE  BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    DECODE(@[cng_indiv_cd], 'O', BV.POL_CD, BV.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND    BV.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("AND    BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    DECODE(@[cng_indiv_cd], 'O', BV.POL_CD, BV.POD_CD) = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    NVL(VPS.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("GROUP BY BV.VSL_PRE_PST_CD, VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("VPS.VPS_PORT_CD )" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    DECODE(@[cng_indiv_cd], 'O', A.POL_CD, A.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("AND    A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    DECODE(@[cng_indiv_cd], 'O', A.POL_CD, A.POD_CD) = B.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    B.CLPT_IND_SEQ  = X_CALL_IND" ).append("\n"); 
		query.append("AND    A.VSL_PRE_PST_CD  = X_BV_IND" ).append("\n"); 

	}
}