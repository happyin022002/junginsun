/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.07.30 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoBkgInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.BL_NO,@[bl_no],'I','B') as ibd_bkg_ind," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.BKG_NO,A.BKG_NO) as bkg_no," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("                                     A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) as vsk_vvd_cd, " ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.VSL_CD," ).append("\n"); 
		query.append("                                     A.VSL_CD) as VSL_CD," ).append("\n"); 
		query.append("	   DECODE(B.BL_NO,@[bl_no],B.SKD_VOY_NO," ).append("\n"); 
		query.append("                                     A.SKD_VOY_NO) as SKD_VOY_NO," ).append("\n"); 
		query.append("	   DECODE(B.BL_NO,@[bl_no],B.SKD_DIR_CD," ).append("\n"); 
		query.append("                                     A.SKD_DIR_CD) as SKD_DIR_CD,                                      " ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.CSTMS_POL_CD, NVL(A.PRE_RLY_PORT_CD, A.POL_CD)) as pol_cd," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.CSTMS_POD_CD, NVL(A.PST_RLY_PORT_CD, A.POD_CD))as pod_Cd," ).append("\n"); 
		query.append("       DECODE(B.BL_NO,@[bl_no],B.DEL_CD, A.DEL_CD) as del_cd" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append(" WHERE A.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("   AND B.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("   AND A.BL_NO     = B.BL_NO(+)" ).append("\n"); 

	}
}