/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchVVDExrateDateForThirdOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchVVDExrateDateForThirdOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVVDExrateDateForThirdOffice
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchVVDExrateDateForThirdOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchVVDExrateDateForThirdOfficeRSQL").append("\n"); 
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
		query.append("SELECT A.XCH_RT_DT" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT_DT A" ).append("\n"); 
		query.append("   , BKG_RATE B" ).append("\n"); 
		query.append("   , MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE  A.VSL_CD = @[vsl]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = @[voy]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[dep]" ).append("\n"); 
		query.append("AND    A.PORT_CD = DECODE(SUBSTR(@[bnd],1,1), 'O', @[pol], @[pod])" ).append("\n"); 
		query.append("AND    A.SVC_SCP_CD  = @[svc_scp]" ).append("\n"); 
		query.append("AND    A.IO_BND_CD = SUBSTR(@[bnd],1,1)" ).append("\n"); 
		query.append("AND	   A.AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("AND    C.OFC_CD = DECODE(SUBSTR(@[bnd],1,1), 'O', B.PPD_RCV_OFC_CD, B.CLT_OFC_CD)" ).append("\n"); 
		query.append("AND    B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 

	}
}