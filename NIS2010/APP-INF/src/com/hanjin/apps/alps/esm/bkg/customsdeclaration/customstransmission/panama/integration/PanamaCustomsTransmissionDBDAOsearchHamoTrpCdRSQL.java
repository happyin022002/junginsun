/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchHamoTrpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchHamoTrpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHamoTrpCd
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchHamoTrpCdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("SUBSTR(F.HAMO_TRF_CD, 1, 6) HAMO_TRF_CD," ).append("\n"); 
		query.append("COUNT(F.HAMO_TRF_CD) HAMOCOUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD A," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD C," ).append("\n"); 
		query.append("BKG_BOOKING D," ).append("\n"); 
		query.append("BKG_CONTAINER E," ).append("\n"); 
		query.append("BKG_CNTR_MF_DESC F" ).append("\n"); 
		query.append("WHERE A.VSL_CD          =  @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO   =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD      =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD          =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO   =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD      =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD      =  A.POL_CD" ).append("\n"); 
		query.append("AND C.VSL_CD          =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO   =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD      =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.VPS_PORT_CD      =  A.POD_CD" ).append("\n"); 
		query.append("AND C.CLPT_SEQ    >  B.CLPT_SEQ" ).append("\n"); 
		query.append("AND B.CLPT_SEQ    <= @[clpt_seq]" ).append("\n"); 
		query.append("AND C.CLPT_SEQ    >  @[clpt_seq]" ).append("\n"); 
		query.append("AND D.BKG_NO          =  A.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_STS_CD         IN ('W', 'F')" ).append("\n"); 
		query.append("AND D.BKG_CGO_TP_CD      =  'F'" ).append("\n"); 
		query.append("AND E.BKG_NO          =  D.BKG_NO" ).append("\n"); 
		query.append("AND F.BKG_NO          =  E.BKG_NO" ).append("\n"); 
		query.append("AND F.CNTR_NO         =  E.CNTR_NO" ).append("\n"); 
		query.append("AND F.HAMO_TRF_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY SUBSTR(F.HAMO_TRF_CD, 1, 6)" ).append("\n"); 
		query.append("ORDER BY 2 DESC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchHamoTrpCdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}