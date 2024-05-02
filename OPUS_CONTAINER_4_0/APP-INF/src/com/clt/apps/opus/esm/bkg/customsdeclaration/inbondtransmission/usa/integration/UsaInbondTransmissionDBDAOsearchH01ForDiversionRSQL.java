/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchH01ForDiversionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchH01ForDiversionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * H01 For Diversion (ESM_BKG_0034)
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchH01ForDiversionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchH01ForDiversionRSQL").append("\n"); 
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
		query.append("	RPAD('H01Z'||" ).append("\n"); 
		query.append("	     RPAD( B.IBD_TRSP_NO  ,14,' ')||" ).append("\n"); 
		query.append("	     RPAD( 	TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, 'USNYC'), 'YYMMDD')  ,6,' ')||" ).append("\n"); 
		query.append("	     RPAD(LOC_AMS_PORT_CD,4,' ')||" ).append("\n"); 
		query.append("	     RPAD(' ',14, ' ')|| " ).append("\n"); 
		query.append("         RPAD(@[irs_no],12,' ')" ).append("\n"); 
		query.append("    ,80,' ')||CHR(10)" ).append("\n"); 
		query.append(" FROM BKG_CSTMS_ADV_BL A, BKG_CSTMS_ADV_IBD B,  MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND A.CNT_CD= B.CNT_CD" ).append("\n"); 
		query.append("AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("AND A.HUB_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 

	}
}