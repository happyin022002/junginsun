/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_VVD 에서 변경된 FM,TO 에 맞는 IN,OUT VVD 찾아오기
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchBkgVvdRSQL(){
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
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration ").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchBkgVvdRSQL").append("\n"); 
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
		query.append("SELECT  (SELECT NVL(IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD, ' ')" ).append("\n"); 
		query.append("FROM BKG_VVD IB" ).append("\n"); 
		query.append("WHERE IB.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("AND IB.POD_CD = TMP.FM_NOD_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) BKG_VVD_IB" ).append("\n"); 
		query.append(",(SELECT NVL(OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD, ' ')" ).append("\n"); 
		query.append("FROM BKG_VVD OB" ).append("\n"); 
		query.append("WHERE OB.BKG_NO = TMP.BKG_NO" ).append("\n"); 
		query.append("AND OB.POL_CD = ( CASE WHEN TMP.TRSP_BND_CD <> 'O' THEN TMP.FM_NOD_CD" ).append("\n"); 
		query.append("ELSE TMP.TO_NOD_CD END )" ).append("\n"); 
		query.append("AND ROWNUM = 1) BKG_VVD_OB" ).append("\n"); 
		query.append("FROM (SELECT @[bkg_no] BKG_NO, @[fm_nod_cd] FM_NOD_CD, @[to_nod_cd] TO_NOD_CD, @[trsp_bnd_cd] TRSP_BND_CD FROM DUAL) TMP" ).append("\n"); 

	}
}