/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchVvdDiffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchVvdDiffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchVvdDiffRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source_bkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_bkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration ").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchVvdDiffRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(TGT.BKG_NO),COUNT(SRC.BKG_NO),'Y','N') AS DIFF" ).append("\n"); 
		query.append("FROM BKG_VVD TGT" ).append("\n"); 
		query.append(",BKG_VVD SRC" ).append("\n"); 
		query.append("WHERE TGT.BKG_NO = @[target_bkg]" ).append("\n"); 
		query.append("AND SRC.BKG_NO(+) = @[source_bkg]" ).append("\n"); 
		query.append("AND TGT.VSL_PRE_PST_CD = SRC.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND TGT.VSL_SEQ = SRC.VSL_SEQ(+)" ).append("\n"); 
		query.append("AND NVL(TGT.VSL_CD,'X') = NVL(SRC.VSL_CD(+),'X')" ).append("\n"); 
		query.append("AND NVL(TGT.SKD_VOY_NO,'X') = NVL(SRC.SKD_VOY_NO(+),'X')" ).append("\n"); 
		query.append("AND NVL(TGT.SKD_DIR_CD,'X') = NVL(SRC.SKD_DIR_CD(+),'X')" ).append("\n"); 
		query.append("AND TGT.POL_CD = SRC.POL_CD(+)" ).append("\n"); 
		query.append("AND TGT.POL_YD_CD = SRC.POL_YD_CD(+)" ).append("\n"); 
		query.append("AND TGT.POD_CD = SRC.POD_CD(+)" ).append("\n"); 
		query.append("AND TGT.POD_YD_CD = SRC.POD_YD_CD(+)" ).append("\n"); 

	}
}