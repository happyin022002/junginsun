/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOcheckOBLRlseByLclRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.10 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOcheckOBLRlseByLclRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 B/L이 LCL일 경우 관련 B/L들에 대한 전체 O/BL Staus를 확인 한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOcheckOBLRlseByLclRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOcheckOBLRlseByLclRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) FROM BKG_BL_ISS" ).append("\n"); 
		query.append("WHERE OBL_RDEM_FLG = 'N'" ).append("\n"); 
		query.append("AND BKG_NO IN ( SELECT BKG2.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNTR1," ).append("\n"); 
		query.append("BKG_BOOKING BKG1," ).append("\n"); 
		query.append("BKG_BOOKING BKG2," ).append("\n"); 
		query.append("BKG_CONTAINER CNTR2" ).append("\n"); 
		query.append("WHERE CNTR1.BKG_NO    = @[bkg_no]      -- cntr1" ).append("\n"); 
		query.append("AND CNTR1.CNTR_PRT_FLG = 'Y'" ).append("\n"); 
		query.append("AND CNTR1.BKG_NO    = BKG1.BKG_NO    -- bkg1" ).append("\n"); 
		query.append("AND BKG1.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BKG1.VSL_CD = BKG2.VSL_CD        -- bkg2" ).append("\n"); 
		query.append("AND BKG1.SKD_VOY_NO = BKG2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BKG1.SKD_DIR_CD = BKG2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BKG1.POL_CD     = BKG2.POL_CD" ).append("\n"); 
		query.append("AND BKG1.BKG_NO     <> BKG2.BKG_NO" ).append("\n"); 
		query.append("AND BKG2.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND CNTR2.BKG_NO    = BKG2.BKG_NO    -- cntr2" ).append("\n"); 
		query.append("AND CNTR2.CNTR_NO   = CNTR1.CNTR_NO" ).append("\n"); 
		query.append("AND CNTR2.CNTR_PRT_FLG='Y' )" ).append("\n"); 

	}
}