/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelScgManageDBDAODeleteFuelScgAgmtVerifyDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.05.07 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAODeleteFuelScgAgmtVerifyDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Verify Data를 Global Temp table에 Insert 하기 전에 삭제하는 작업, session 단위 temp table이기때문에 이 작업이 꼭 필요하다.
	  * </pre>
	  */
	public FuelScgManageDBDAODeleteFuelScgAgmtVerifyDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ").append("\n"); 
		query.append("FileName : FuelScgManageDBDAODeleteFuelScgAgmtVerifyDataDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_AGMT_TMP" ).append("\n"); 
		query.append("WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 

	}
}