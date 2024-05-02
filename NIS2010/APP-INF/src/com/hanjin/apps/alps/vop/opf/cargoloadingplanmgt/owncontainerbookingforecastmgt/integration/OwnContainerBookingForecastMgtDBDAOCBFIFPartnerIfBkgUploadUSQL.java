/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgUploadUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgUploadUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi upload 완료
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgUploadUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgUploadUSQL").append("\n"); 
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
		query.append("UPDATE OPF_PRNR_EDI_CGO_BKG_FCAST A SET UPLD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND YD_CD            = @[pol_cd]" ).append("\n"); 
		query.append("  AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("  AND UPLD_DT IS NULL" ).append("\n"); 
		query.append("  AND NOT EXISTS (  SELECT * FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                            WHERE VSL_CD           = A.VSL_CD" ).append("\n"); 
		query.append("                              AND SKD_VOY_NO       = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                              AND SKD_DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                              AND YD_CD            = A.YD_CD" ).append("\n"); 
		query.append("                              AND POL_CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              AND EDI_RCV_DT       = A.EDI_RCV_DT" ).append("\n"); 
		query.append("                              AND EDI_SND_ID       = A.EDI_SND_ID" ).append("\n"); 
		query.append("                              AND ( CRR_CD IS NULL OR POD_CD IS NULL OR CNTR_TPSZ_CD IS NULL ) )" ).append("\n"); 

	}
}