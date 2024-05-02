/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAODBDAOCBFIFPartnerPortCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAODBDAOCBFIFPartnerPortCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner edi 의 port code가져오기
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAODBDAOCBFIFPartnerPortCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAODBDAOCBFIFPartnerPortCodeRSQL").append("\n"); 
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
		query.append("WITH V_PORT AS " ).append("\n"); 
		query.append("( SELECT UNIV_CD AS PORT_CD FROM STO_CD_EDI_CNVT" ).append("\n"); 
		query.append("   WHERE CATE_CD  ='PORT'" ).append("\n"); 
		query.append("     AND PRNR_CD  = 'ZZZZZ'" ).append("\n"); 
		query.append("     AND PRIV_CD  = @[port_cd]" ).append("\n"); 
		query.append("   UNION " ).append("\n"); 
		query.append("   SELECT LOC_CD AS PORT_CD  FROM MDM_LOCATION" ).append("\n"); 
		query.append("    WHERE UN_LOC_CD = @[port_cd]" ).append("\n"); 
		query.append("      AND DELT_FLG  ='N' ) " ).append("\n"); 
		query.append("SELECT  DECODE( (SELECT COUNT(1) FROM V_PORT), 1, PORT_CD, NULL)" ).append("\n"); 
		query.append(" FROM V_PORT " ).append("\n"); 

	}
}