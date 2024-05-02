/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOcheckEuFullRlseTransmitValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.11.29 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOcheckEuFullRlseTransmitValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pickup Date 및 Release Eapire Date 에 해당하는 부킹데이타의 유무 체크
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOcheckEuFullRlseTransmitValidRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOcheckEuFullRlseTransmitValidRSQL").append("\n"); 
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
		query.append("SELECT DECODE(count(*),0,'N','Y')" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("    ,BKG_HRD_CDG_CTNT B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   B.HRD_CDG_ID = 'EU_FULL_CHK_ITM'" ).append("\n"); 
		query.append("AND   SUBSTR(A.POD_CD,1,2) = B.ATTR_CTNT1" ).append("\n"); 
		query.append("#if (${chk_itm} == 'P')" ).append("\n"); 
		query.append("AND   B.ATTR_CTNT2 ='Y'   -- Pick Date Check" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   B.ATTR_CTNT3 ='Y'   -- Rlse Expire Date Check" ).append("\n"); 
		query.append("AND   B.ATTR_CTNT10 = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}