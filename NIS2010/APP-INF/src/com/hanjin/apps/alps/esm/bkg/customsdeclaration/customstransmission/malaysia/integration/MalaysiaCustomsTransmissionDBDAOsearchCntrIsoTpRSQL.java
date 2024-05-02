/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOsearchCntrIsoTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : 장인호
*@LastVersion : 1.0
* 2013.05.20 장인호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author janginho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOsearchCntrIsoTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container ISO Type Code 조회해옴
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOsearchCntrIsoTpRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOsearchCntrIsoTpRSQL").append("\n"); 
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
		query.append("SELECT MDM.CNTR_TPSZ_ISO_CD CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("WHERE  CNTR.BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND CNTR.CNTR_TPSZ_CD = MDM.CNTR_TPSZ_CD" ).append("\n"); 

	}
}