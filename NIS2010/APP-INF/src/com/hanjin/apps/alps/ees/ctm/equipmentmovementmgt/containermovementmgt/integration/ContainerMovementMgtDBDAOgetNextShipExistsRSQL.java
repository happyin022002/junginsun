/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetNextShipExistsRSQL.java
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.31 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyung Min Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetNextShipExistsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 다음배가 존재하는지 판별 (VD)
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetNextShipExistsRSQL(){
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
		params.put("dir",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetNextShipExistsRSQL").append("\n"); 
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
		query.append("SELECT VSL_PRE_PST_CD, VSL_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD," ).append("\n"); 
		query.append("POD_CD, DECODE (NEXT_VSL, NULL, 'N', 'Y') NXTSHIP" ).append("\n"); 
		query.append("FROM (SELECT VSL_PRE_PST_CD, VSL_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("POL_CD, POD_CD," ).append("\n"); 
		query.append("LEAD (VSL_PRE_PST_CD, 1) OVER (PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD" ).append("\n"); 
		query.append("|| VSL_SEQ) NEXT_VSL" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[voy]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[dir]" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("AND POL_CD = SUBSTR(@[pol],0,5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND POD_CD = SUBSTR(@[pod],0,5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}